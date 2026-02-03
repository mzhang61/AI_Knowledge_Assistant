package com.atguigu.javaailangchain4j;

import com.atguigu.javaailangchain4j.assistant.Assistant;
import com.atguigu.javaailangchain4j.assistant.MemoryChatAssistant;
import com.atguigu.javaailangchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ChatMemoryTest {

    @Autowired
    private Assistant assistant;
    // no memory
    @Test
    public void testChatMemory() {
        String answer1 = assistant.chat("I'm LingLing");
        System.out.println(answer1);

        String answer2 = assistant.chat("Who am I");
        System.out.println(answer2);
    }

    @Autowired
    private QwenChatModel qwenChatModel;
    @Test
    public void testChatMemory2() {
        // first dialogue
        UserMessage userMessage1 = UserMessage.userMessage("I'm LingLing");
        ChatResponse chatResponse1 = qwenChatModel.chat(userMessage1);
        AiMessage aiMessage1 = chatResponse1.aiMessage();
        // output response
        System.out.println(aiMessage1.text());

        // second dialogue with memorization uses message recall
        UserMessage userMessage2 = UserMessage.userMessage("Do you know who am I");
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(userMessage1, aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
        // output response
        System.out.println(aiMessage2.text());
    }

    // chatmodel memory api
    @Test
    public void testChatMemory3() {
        // create chat memory
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        // create AIService
        Assistant assistant = AiServices
                .builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(chatMemory)
                .build();


        String answer1 = assistant.chat("I am LingLing");
        System.out.println(answer1);
        String answer2 = assistant.chat("who am I");
        System.out.println(answer2);
    }

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;
    @Test
    public void testChatMemory4() {
        String answer1 = memoryChatAssistant.chat("I am Lingling"); System.out.println(answer1);
        String answer2 = memoryChatAssistant.chat("who am I"); System.out.println(answer2);
    }

    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testChatMemory5() {
        String answer1 = separateChatAssistant.chat(1,"I am Lingling"); System.out.println(answer1);
        String answer2 = separateChatAssistant.chat(1,"who am I"); System.out.println(answer2);
        String answer3 = separateChatAssistant.chat(2,"who am I"); System.out.println(answer3);
    }
}
