<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:7C2D12,50:B45309,100:D4AF37&height=210&section=header&text=Hotel%20Management%20System&fontSize=44&fontColor=ffffff&animation=fadeIn&fontAlignY=38&desc=Front%20Desk%20%C2%B7%20Staff%20%C2%B7%20Housekeeping%20%C2%B7%20Transport%20%E2%80%94%20One%20Desktop%20App&descAlignY=58&descSize=16&descColor=FDE9C8" width="100%"/>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=20&pause=1100&color=D4AF37&center=true&vCenter=true&width=680&lines=Check-in+to+check-out%2C+one+app;Front+desk.+HR.+Housekeeping.+Transport.;Java+Swing+%2B+MySQL.+Fully+offline." alt="Typing SVG" />

<br/>

[![Java](https://img.shields.io/badge/Java-JDK%2011+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Swing](https://img.shields.io/badge/GUI-Java%20Swing-007396?style=for-the-badge&logo=java&logoColor=white)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![MySQL](https://img.shields.io/badge/Database-MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-D4AF37?style=for-the-badge)](#-license)

[![Stars](https://img.shields.io/github/stars/Crusty-chirayu/Hotel-Management-System?style=flat-square&color=yellow)](https://github.com/Crusty-chirayu/Hotel-Management-System/stargazers)
[![Forks](https://img.shields.io/github/forks/Crusty-chirayu/Hotel-Management-System?style=flat-square&color=B45309)](https://github.com/Crusty-chirayu/Hotel-Management-System/forks)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-7C2D12?style=flat-square)](#-contributing)

</div>

---

## 🔑 Legend

| Symbol | Meaning |
|:---:|---|
| ✅ | Confirmed — a real `.java` file in the repo implements this |
| 🚧 | Planned — listed in [Future Improvements](#-future-improvements), not yet in the codebase |
| `TODO` | Not confirmed during this review — verify before relying on it |

---

## 📌 Overview

**Hotel Management System** is a desktop application that runs the operational core of a small hotel — not just bookings. Front desk, staff records, housekeeping, and guest transport all live in one Java Swing GUI backed by MySQL, with zero cloud dependency and zero per-seat SaaS fees.

It replaces four separate spreadsheets (guests, staff, housekeeping, pickups) with one structured app any front-desk PC can run.

<br/>

## 📚 Table of Contents

- [Live Preview](#-live-preview)
- [Features](#-features)
- [Module Status](#-module-status)
- [Tech Stack](#️-tech-stack)
- [Architecture](#️-architecture)
- [Screenshots](#️-screenshots)
- [Prerequisites](#-prerequisites)
- [Installation & Setup](#-installation--setup)
- [Usage](#️-usage)
- [Project Structure](#-project-structure)
- [Security Notes](#-security-notes)
- [Future Improvements](#-future-improvements)
- [Contributing](#-contributing)
- [FAQ](#-faq)
- [Author](#-author)
- [License](#-license)


## ✨ Features

> Grouped by the real modules present in the codebase — not a generic feature list. Every row below maps to an actual `.java` file.

### 🛎️ Front Desk & Room Operations
| Feature | Source |
|---|---|
| Add / search / update rooms | `AddRoom.java`, `SearchRoom.java`, `UpdateRoom.java`, `Room.java` |
| New customer registration & customer records | `NewCustomer.java`, `CustomerInfo.java` |
| Check-out & stay updates | `CheckOut.java`, `UpdateCheck.java` |
| Customer / booking reports | `CustomerReport.java` |
| Reception desk view | `Reception.java` |

### 👥 Staff & HR
| Feature | Source |
|---|---|
| Add & manage employees | `AddEmployee.java`, `Employee.java` |
| Department structure | `Department.java` |
| Manager records | `ManagerInfo.java` |
| Admin controls | `Admin.java` |

### 🧹 Housekeeping & 🚐 Transport
| Feature | Source |
|---|---|
| Housekeeping task tracking | `Housekeeping.java` |
| Driver registry | `AddDriver.java` |
| Guest pickup coordination | `PickUp.java` |

### 🖥️ App Shell
| Feature | Source |
|---|---|
| Splash screen | `Splash.java` |
| Login (dual login paths) | `Login.java`, `Login2.java` |
| Central dashboard | `Dashboard.java` |
| MySQL connectivity layer | `connection.java` |

<sub>💡 This is a materially bigger feature set than a typical "rooms + check-in" hotel demo — the staff/HR, housekeeping, and transport modules above weren't called out in earlier drafts of this README even though the code for them already exists.</sub>

<br/>

## 📊 Module Status

<div align="center">

| Module | Status |
|---|:---:|
| Front desk (rooms, customers, checkout) | ✅ |
| Staff / HR management | ✅ |
| Housekeeping | ✅ |
| Driver & pickup coordination | ✅ |
| Login & dashboard shell | ✅ |
| Multi-role authentication | 🚧 |
| PDF / Excel reporting | 🚧 |
| Modernized theming (FlatLaf) | 🚧 |
| Email notifications | 🚧 |

</div>

<br/>

## 🛠️ Tech Stack

<div align="center">

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/)
[![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)](https://netbeans.apache.org/)

</div>

| Layer | Technology |
|---|---|
| **Language** | Java |
| **GUI Framework** | Java Swing |
| **Database** | MySQL |
| **DB Driver** | MySQL Connector/J 8.0.28 — bundled directly in the repo (`mysql-connector-java-8.0.28.jar`), no separate download needed |
| **IDE (confirmed)** | IntelliJ IDEA — `HMS.iml` project file is checked into the repo |
| **IDE (also works)** | NetBeans / Eclipse |
| **License** | MIT — `LICENSE` file present in repo |

<br/>

## 🏗️ Architecture

```mermaid
flowchart TD
    Splash["🌅 Splash.java"] --> Login["🔐 Login.java / Login2.java"]
    Login --> Dashboard["🖥️ Dashboard.java"]

    Dashboard --> Reception["🛎️ Reception.java"]
    Reception --> RoomOps["Room.java · AddRoom · SearchRoom · UpdateRoom"]
    Reception --> GuestOps["NewCustomer · CustomerInfo · CheckOut · UpdateCheck · CustomerReport"]

    Dashboard --> Admin["🛡️ Admin.java"]
    Admin --> HR["AddEmployee · Employee · ManagerInfo · Department"]

    Dashboard --> Housekeeping["🧹 Housekeeping.java"]
    Dashboard --> Transport["🚐 AddDriver.java · PickUp.java"]

    RoomOps --> Conn["🔌 connection.java"]
    GuestOps --> Conn
    HR --> Conn
    Housekeeping --> Conn
    Transport --> Conn

    Conn --> DB[("🗄️ MySQL Database")]

    style DB fill:#7C2D12,color:#fff
    style Conn fill:#B45309,color:#fff
```

<sub>Reconstructed from the files present in the repository, not a documented architecture diagram from the source — module boundaries (e.g. exactly which classes call `connection.java` directly vs. through an intermediary) are `TODO` to confirm against the source.</sub>

<br/>

## 🖼️ Screenshots

<div align="center">

<img width="800" alt="Hotel Management System - Main Dashboard" src="https://github.com/user-attachments/assets/f3b569c3-4752-4f65-a46a-d926e4bbd0b4" />

<img width="500" alt="Hotel Management System - Booking Window" src="https://github.com/user-attachments/assets/5a155b9d-c5bc-439d-ab5e-447fc7858a1f" />

<img width="700" alt="Hotel Management System - Customer Records" src="https://github.com/user-attachments/assets/77b70ca9-85a8-42d0-bf1d-67d0d28270cd" />

<img width="800" alt="Hotel Management System - Check-In/Check-Out" src="https://github.com/user-attachments/assets/be7513f0-d102-4fc7-bef7-5879d260d90b" />

<img width="600" alt="Hotel Management System - Additional View 1" src="https://github.com/user-attachments/assets/685bea0d-d5ba-4f6f-bb97-67e759bf95e7" />

<img width="450" alt="Hotel Management System - Additional View 2" src="https://github.com/user-attachments/assets/3431c5c3-d431-4ef3-85d3-d92035a9d077" />

<img width="800" alt="Hotel Management System - Additional View 3" src="https://github.com/user-attachments/assets/8b5463c1-2827-453e-aee5-78e52954a181" />

<br/><br/>

**Bonus assets already in the repo, not previously shown:**

<img width="260" alt="Add Employee screen" src="https://raw.githubusercontent.com/Crusty-chirayu/Hotel-Management-System/main/addemp.png" />
<img width="260" alt="Customer screen" src="https://raw.githubusercontent.com/Crusty-chirayu/Hotel-Management-System/main/customer.png" />
<img width="260" alt="Admin / boss view" src="https://raw.githubusercontent.com/Crusty-chirayu/Hotel-Management-System/main/boss.png" />

</div>

<br/>

## 📋 Prerequisites

- ☑️ **Java JDK 11+** installed
- ☑️ **MySQL Server** installed and running
- ☑️ An IDE — **IntelliJ IDEA** (project file included), NetBeans, or Eclipse

<br/>

## 🚀 Installation & Setup

**1. Clone the repository**
```bash
git clone https://github.com/Crusty-chirayu/Hotel-Management-System.git
```

**2. Open the project**
Open the folder directly in **IntelliJ IDEA** (it already has `HMS.iml`), or import it as a Java project into NetBeans/Eclipse.

**3. Set up the database**
> ⚠️ **Honesty check:** no `.sql` schema file was found in the repository's top-level listing at the time this README was written. Either it lives somewhere not shown in the root listing, or it still needs to be added/exported. Confirm this before following the step below — if there's no schema file, export one from your local database once the tables referenced by `connection.java` and the model classes are created, and commit it so this step is reproducible for the next person.

- Create a MySQL database matching what `connection.java` expects
- Import the schema (`.sql` file) once its location is confirmed

**4. Configure the connection**
Open `connection.java` and update the host, port, username, password, and database name to match your local MySQL setup.

**5. Run the project**
> `TODO`: no `Main.java` appears in the repository's root file listing. `Splash.java` is the most likely entry point given the naming pattern (splash screen → login → dashboard), but confirm which class holds `public static void main(String[] args)` before documenting this as fact.

Run the confirmed entry-point class from your IDE — the application window should launch immediately.

<br/>

## 🖱️ Usage

Once the application is running:

- ➕ Add new customers and assign rooms
- 🔄 Manage check-ins and check-outs
- 👥 Add employees, assign departments, and manage manager records
- 🧹 Track housekeeping tasks
- 🚐 Register drivers and coordinate guest pickups
- 📊 View all bookings and customer details in a structured table
- ✏️ Edit or delete records as needed

<br/>

## 📁 Project Structure

```
Hotel-Management-System/
├── Splash.java                     # App entry screen
├── Login.java / Login2.java        # Authentication (two variants)
├── Dashboard.java                  # Central navigation hub
├── Admin.java                      # Admin controls
├── Reception.java                  # Front desk view
├── Room.java / AddRoom.java / SearchRoom.java / UpdateRoom.java
├── NewCustomer.java / CustomerInfo.java / CustomerReport.java
├── CheckOut.java / UpdateCheck.java
├── AddEmployee.java / Employee.java / ManagerInfo.java / Department.java
├── Housekeeping.java
├── AddDriver.java / PickUp.java
├── connection.java                 # MySQL connectivity
├── mysql-connector-java-8.0.28.jar # Bundled DB driver
├── HMS.iml                         # IntelliJ project file
├── LICENSE                         # MIT
└── README.md
```

<sub>⚠️ Everything currently sits at the repository root with no package structure — flagged below under [Future Improvements](#-future-improvements) as a maintainability opportunity, not a bug.</sub>

<br/>

## 🔐 Security Notes

- `connection.java` holds the MySQL connection details — confirm whether host/username/password are hardcoded or externalized. If hardcoded, that's the first thing to fix before this touches any shared or production database.
- `TODO`: confirm whether queries use `PreparedStatement` (parameterized) or raw string-concatenated SQL — the latter would be a SQL-injection risk across the customer, employee, and room modules.
- Only one authentication path is confirmed (`Login.java` / `Login2.java`); role-based access control (admin vs. staff) is listed under [Future Improvements](#-future-improvements) rather than confirmed as implemented today.

<br/>

## 🔮 Future Improvements

- [ ] 📄 PDF / Excel report generation for bookings
- [ ] 🔐 Multiple staff roles with authentication
- [ ] 🎨 Modernized GUI with updated Swing themes / FlatLaf
- [ ] 📧 Email notifications for bookings and check-outs
- [ ] 📦 Organize source into packages (`ui/`, `db/`, `model/`) instead of a flat file layout
- [ ] 🗄️ Commit the database schema (`.sql`) to the repo so setup is reproducible
- [ ] 🧾 Clarify/rename the entry-point class so `Getting Started` doesn't require guessing
- [ ] 🔒 Externalize DB credentials out of `connection.java` (config file / environment variables)

<br/>

## 🤝 Contributing

Pull requests are welcome. For larger changes, open an issue first to discuss direction.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add your feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

<br/>

## ❓ FAQ

**Is this only for room bookings?**
No — it also covers staff/HR records, housekeeping tracking, and guest pickup coordination. See [Features](#-features).

**Does it need internet access to run?**
No — it's fully offline once Java and a local MySQL server are set up.

**Which class do I actually run to start the app?**
Not confirmed in this README — see the note under [Installation & Setup](#-installation--setup). `Splash.java` is the best current guess based on naming convention.

**Is there a hosted demo?**
No — it's a desktop application. See [Live Preview](#-live-preview) for a real GIF capture instead.

<br/>

## 👤 Author

<div align="center">

**Chirayu Jayaswal**

[![GitHub](https://img.shields.io/badge/GitHub-Crusty--chirayu-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Crusty-chirayu)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-chirayu--jayaswal-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/chirayu-jayaswal)
[![Portfolio](https://img.shields.io/badge/Portfolio-Visit-000000?style=for-the-badge&logo=vercel&logoColor=white)](https://portfolio-lac-kappa-49.vercel.app)

</div>

<br/>

## 📄 License

MIT — see [`LICENSE`](LICENSE) for details.

<div align="center">

⭐ **If this project helped you, consider giving it a star!** ⭐

<sub>No star-history chart here on purpose — GitHub has been restricting third-party access to stargazer history data, which breaks those charts. A static star count badge (above) doesn't depend on that endpoint, so it's used instead.</sub>

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:D4AF37,50:B45309,100:7C2D12&height=120&section=footer" width="100%"/>

</div>
