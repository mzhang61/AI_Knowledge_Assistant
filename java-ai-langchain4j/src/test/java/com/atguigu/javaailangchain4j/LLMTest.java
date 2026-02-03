package com.atguigu.javaailangchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;

import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class LLMTest {

    @Test
    public void testGPTDemo() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();

        String answer = model.chat("who are you");
        System.out.println(answer);
    }

    @Autowired
    private OpenAiChatModel openAiChatModel;
    // private OpenAiChatModel openAiChatModel;

    @Test
    public void testSpringBoot() {
        String answer = openAiChatModel.chat("who are you?");
        System.out.println(answer);

    }

    @Autowired
    private OllamaChatModel ollamaChatModel;

    @Test
    public void testOllama() {
        String answer = ollamaChatModel.chat("Who are you");
        System.out.println(answer);
    }

    // qwen model test
    @Autowired
    private QwenChatModel qwenChatModel;
    @Test
    public void testDashScopeQwen() {

        String answer = qwenChatModel.chat("hello, who are you");
        System.out.println(answer);
    }

    @Test
    public void testDashScopeWanx() {
        WanxImageModel wanxImageModel = WanxImageModel.builder()
                .modelName("wanx2.1-t2i-plus")
                .apiKey(System.getenv("DASH_SCOPE_API_KEY"))
                .build();
        Response<Image> response = wanxImageModel.generate("Steampunk City: Massive gears and pipelines crisscross and cover the buildings throughout the city. Towering smokestacks release thick black smoke, turning the sky a dark gray. On the streets, steam-powered mechanical vehicles move back and forth, producing loud, roaring noises. People wear leather trench coats, goggles, and metal helmets, carrying various mechanical tools and weapons. A gigantic clock tower stands at the center of the city, with gears spinning rapidly as deep, echoing chimes ring out. At the edge of the city, enormous steam-powered airships slowly rise into the sky, preparing to begin new journeys.");
        System.out.println(response.content().url());
    }
}
