# System Architecture

## Overview

AI Game Master follows a microservice-based architecture.

The system separates deterministic game logic from AI-generated content.

Java Spring Boot acts as the main game engine and orchestrator, while Python provides AI-powered content generation.

---

## Components

### Frontend
Responsibilities:
- Display the game world
- Render maps
- Show dialogues
- Display inventory
- Handle player input

Technology:
- React
- Phaser.js

---

### Game Engine (Java Spring Boot)

Responsibilities:

- Game session management
- Player management
- NPC management
- Combat logic
- Inventory
- Reputation
- Time system
- Save/Load system
- Database communication
- AI service communication

---

### AI Service (Python)

Responsibilities:

- World lore generation
- NPC dialogue generation
- Quest generation
- Story generation
- Semantic memory retrieval

---

### Database (PostgreSQL)

Stores:

- Players
- NPCs
- Cities
- Kingdoms
- Quests
- Inventory
- Reputation
- World state
- Game saves

---

## Communication Flow

Player

↓

React Frontend

↓

Java Spring Boot

↓

PostgreSQL

↓

Python AI Service

↓

LLM

Java coordinates all communication.
The AI service never communicates directly with the frontend.