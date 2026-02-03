A full-stack AI-powered medical assistant built with LangChain4j, featuring multi-model LLM integration, RAG, function calling, persistent chat memory, and local LLM deployment via Ollama.**

![image-20260126111239956](/Users/mmm/Library/Application Support/typora-user-images/image-20260126111239956.png)

Built an AI-powered medical assistant using Spring Boot and LangChain4j that supports
multi-turn conversations, appointment booking, and medical Q&A via Retrieval-Augmented Generation (RAG).
Integrated cloud LLMs and locally deployed models via Ollama, with persistent chat memory
and database-backed business workflows.



• Designed an AI Agent architecture using LangChain4j AIService with system/user prompt templates
• Implemented multi-turn chat memory with isolation and persistence using MongoDB
• Integrated Retrieval-Augmented Generation (RAG) using document loaders, text splitters,
  embedding models, and vector search (Pinecone)
• Enabled function calling (Tools) to connect LLM reasoning with real business logic
  (appointment booking, cancellation, availability checks via MySQL)
• Supported multiple LLM backends: Alibaba DashScope (Qwen), DeepSeek, and locally deployed models via Ollama
• Deployed local LLMs using Ollama to improve data privacy, reduce cost, and enable offline inference



Frontend (Web UI / Swagger / Postman)
        ↓
Spring Boot REST Controller
        ↓
Xiaozhi AI Agent (LangChain4j AIService)
        ↓
 ┌───────────────┬────────────────┬─────────────────┐
 │ Chat Memory   │ Tools (Funcs)  │ RAG Retriever   │
 │ (MongoDB)     │ (MySQL)        │ (Pinecone)      │
 └───────────────┴────────────────┴─────────────────┘
        ↓
LLMs (Qwen / DeepSeek / Ollama Local Models)



-------------------------------------------------------------------------------------------





**Retrieval-Augmented Medical AI Assistant**

*Java · Spring Boot · LangChain4j · Ollama · Qwen · Pinecone*

- Designed and implemented a **Retrieval-Augmented Generation (RAG)** system to answer medical queries using trusted domain-specific knowledge.
- Embedded medical documents into high-dimensional vectors using **Qwen embedding models**, enabling semantic understanding beyond keyword matching.
- Indexed and queried embeddings with **Pinecone vector database** to retrieve the most relevant context for each user query.
- Integrated **Ollama-hosted local LLMs (DeepSeek)** for on-device inference, improving data privacy and reducing dependency on external APIs.
- Implemented query workflow: **User Query → Embedding → Vector Search → Context Injection → LLM Response**.
- Built RESTful APIs with **Spring Boot** to orchestrate retrieval, prompt construction, and response generation.
- Reduced hallucination risk by forcing the LLM to answer strictly based on retrieved medical context.
- Supported hybrid architecture combining **local LLM inference** with **cloud-based embedding services**.

### **1️⃣ 为什么要用 RAG？**

> To ground LLM responses in trusted medical knowledge and avoid hallucinations.

### **2️⃣ Pinecone**

> It performs semantic vector search, not text search or answer generation.

### **3️⃣  Ollama？**

> To run LLMs locally for privacy-sensitive scenarios and reduce cloud dependency.



I built a RAG-based medical assistant that retrieves domain knowledge via vector search and generates grounded answers using a locally deployed LLM.”**







