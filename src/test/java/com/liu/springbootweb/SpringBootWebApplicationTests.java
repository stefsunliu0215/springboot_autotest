package com.liu.springbootweb;

import com.liu.springbootweb.entity.Article;
import com.liu.springbootweb.entity.Book;
import com.liu.springbootweb.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationTests {

    @Autowired
    private JestClient jestClient;
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void contextLoads() {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        String[] array = new String[list.size()];
        array = list.toArray(array);

        Map<String, Object> map = new HashMap<>();
        map.put("1", "aaa");
        map.put("2", "bbb");
        map.put("3", "ccc");
        map.put("4", "ddd");
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        for (Map.Entry entry : entrySet) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

    }

    /*测试索引（保存）文档*/
    @Test
    public void index() {
        //向ES索引一个文档
        Article article = new Article(1, "双11大优惠", "liuzhiling", "好消息，好消息");
        //创建一个索引
        Index index = new Index.Builder(article).index("lzl").type("news").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search(){
        //创建一个查询
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"好消息\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("lzl").addType("news").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void add(){
        Book book = new Book(1, "鲁滨逊漂流记1", "liuzhiling");
        Book book1 = new Book(2, "SpringBoot", "liuzhiling");
        Book book2 = new Book(3, "Docker", "liuzhiling");
        bookRepository.index(book);
        bookRepository.index(book1);
        bookRepository.index(book2);
    }

    @Test
    public void find(){
        List<Book> book = bookRepository.findBookByAuthorLike("liu");
        System.out.println(book.toString());
    }

    @Test
    public void delete(){
        bookRepository.deleteById(1);
    }

}
