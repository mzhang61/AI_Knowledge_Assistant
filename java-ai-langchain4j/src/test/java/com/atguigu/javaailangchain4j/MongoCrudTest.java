package com.atguigu.javaailangchain4j;

import com.atguigu.javaailangchain4j.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MongoCrudTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    // work when id in ChatMessages class is Long
   /* @Test
    public void testInsert() {
        mongoTemplate.insert(new ChatMessages(1L, "chat history"));
    }*/

    @Test
    public void testInsert2() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("chat history list");
        mongoTemplate.insert(chatMessages);
    }

    @Test
    public void testFindById() {
        ChatMessages chatMessages = mongoTemplate.findById("696ffd972620fd6e144134a3", ChatMessages.class);
        System.out.println(chatMessages);
    }

    @Test
    public void testUpdate() {
        Criteria criteria = Criteria.where("_id").is("696ffd972620fd6e144134a3");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "new chat history list");

        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    // update or create
    @Test
    public void testUpdate2() {
        Criteria criteria = Criteria.where("_id").is("");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "new chat history list");

        // update or create
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    // delete
    @Test
    public void testDelete() {
        Criteria criteria = Criteria.where("_id").is("696ffd972620fd6e144134a3");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }
}
