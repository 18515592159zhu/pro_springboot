package com.itheima;

import com.alibaba.fastjson.JSON;
import com.itheima.dao.BookDao;
import com.itheima.pojo.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class Springboot18EsApplicationTests {

    @Autowired
    private BookDao bookDao;

    /**
     * 下述操作形式是ES早期的操作方式，使用的客户端被称为Low Level Client
     * 这种客户端操作方式性能方面略显不足，于是ES开发了全新的客户端操作方式，称为High Level Client
     * 高级别客户端与ES版本同步更新，但是springboot最初整合ES的时候使用的是低级别客户端，所以企业开发需要更换成高级别的客户端模式。
     */
    //@Autowired
    //private ElasticsearchRestTemplate template;

    //下面使用高级别客户端方式进行springboot整合ES，操作步骤如下：

    //由于当前客户端是手工维护的，因此不能通过自动装配的形式加载对象。
    private RestHighLevelClient client;

    @BeforeEach
        //在测试类中每个操作运行前运行的方法
    void setUp() {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
    }

    @AfterEach
        //在测试类中每个操作运行后运行的方法
    void tearDown() throws IOException {
        client.close();
    }

    //使用编程的形式设置连接的ES服务器，并获取客户端对象
   /* @Test
    void testCreateClient() throws IOException {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
        client.close();
    }*/

    //使用客户端对象操作ES，例如创建索引
   /* @Test
    void testCreateIndex() throws IOException {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);

        CreateIndexRequest request = new CreateIndexRequest("books");
        client.indices().create(request, RequestOptions.DEFAULT);

        client.close();
    }*/

    @Test
    void testCreateIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    //创建索引（IK分词器）：
    @Test
    void testCreateIndexByIK() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        String json = "{\n" +
                "    \"mappings\":{\n" +
                "        \"properties\":{\n" +
                "            \"id\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"name\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"type\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"description\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"all\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //设置请求中的参数
        request.source(json, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    //添加文档
    public void testCreateDoc() throws IOException {
        Book book = bookDao.selectById(1);
        IndexRequest request = new IndexRequest("books").id(book.getId().toString());
        String json = JSON.toJSONString(book);
        request.source(json, XContentType.JSON);
        client.index(request, RequestOptions.DEFAULT);
    }

    @Test
    //批量添加文档
    public void testCreateDocAll() throws IOException {
        List<Book> bookList = bookDao.selectList(null);
        BulkRequest bulk = new BulkRequest();
        for (Book book : bookList) {
            IndexRequest request = new IndexRequest("books").id(book.getId().toString());
            String json = JSON.toJSONString(book);
            request.source(json, XContentType.JSON);
            bulk.add(request);
        }
        client.bulk(bulk, RequestOptions.DEFAULT);
    }

    @Test
    //按id查询
    //根据id查询文档使用的请求对象是GetRequest
    public void testGet() throws IOException {
        GetRequest request = new GetRequest("books", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        String json = response.getSourceAsString();
        System.out.println(json);
    }

    @Test
    //按条件查询
    public void testSearch() throws IOException {
        SearchRequest request = new SearchRequest("books");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("all", "spring"));
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            String source = hit.getSourceAsString();
            //System.out.println(source);
            Book book = JSON.parseObject(source, Book.class);
            System.out.println(book);
        }
    }
}