# Android Services and Notifications Guide

This repository demonstrates the implementation and management of services in Android, focusing on foreground and background services, their limitations, and notification handling post-Android Oreo (API level 26).

---

## Overview of Android Services

Android services allow tasks to run in the background without direct user interaction. They are a critical component for applications requiring long-running operations.

### Types of Services:
1. **Foreground Services**  
   These services run in the foreground and display a persistent notification. They are commonly used for tasks like music playback or location tracking.
   
2. **Background Services**  
   These services run in the background without direct user interaction. However, they have become increasingly restricted in newer Android versions (starting from Android Oreo). They are used for downloading large files in the background.

---

## Limitations of Background Services and Broadcasts
### Background Services:
- **Android Oreo (API 26) and above:**  
  Background services face significant restrictions to conserve battery and improve performance.
  - Services cannot run freely when the app is in the background.
  - Instead, developers must use **WorkManager** or **JobScheduler** for background tasks.

### Broadcasts:
- Implicit broadcasts (e.g., system-wide events like "BATTERY_LOW") are restricted to reduce system resource usage.
- Developers need to register most broadcasts dynamically or use explicit broadcasts.

---

## Notifications in Android Oreo and Above

Android Oreo introduced **notification channels**, which are mandatory for displaying notifications. A notification channel groups notifications and allows users to control settings like sound, vibration, and importance levels for each channel.

### Demo Image shown below:

<img src="https://github.com/user-attachments/assets/654b2f0c-49d7-4180-a33f-3dfd516ef752" width="200" height="400">
