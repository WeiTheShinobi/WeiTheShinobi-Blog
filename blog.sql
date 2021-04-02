/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.23 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `blog`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(62);

/*Table structure for table `t_blog` */

DROP TABLE IF EXISTS `t_blog`;

CREATE TABLE `t_blog` (
  `id` bigint NOT NULL,
  `appreciation` bit(1) NOT NULL,
  `commentable` bit(1) NOT NULL,
  `content` longtext,
  `create_time` datetime(6) DEFAULT NULL,
  `first_picture` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `recommend` bit(1) NOT NULL,
  `share_statement` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `views` int DEFAULT NULL,
  `type_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK292449gwg5yf7ocdlmswv9w4j` (`type_id`),
  KEY `FK8ky5rrsxh01nkhctmo7d48p82` (`user_id`),
  CONSTRAINT `FK292449gwg5yf7ocdlmswv9w4j` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`),
  CONSTRAINT `FK8ky5rrsxh01nkhctmo7d48p82` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_blog` */

insert  into `t_blog`(`id`,`appreciation`,`commentable`,`content`,`create_time`,`first_picture`,`flag`,`published`,`recommend`,`share_statement`,`title`,`update_time`,`views`,`type_id`,`user_id`,`description`) values 
(47,'','','Hello!','2021-03-26 21:07:29.530000','https://picsum.photos/seed/picsum/800/450','原創','','','','Go 語言 ： 複製貼上導向程式設計','2021-03-27 23:31:55.296000',0,53,1,'學會使用Go說Hello，真是開心，趕緊學習這個快速又簡潔的現代語言！'),
(48,'','','# Spring Boot','2021-03-26 21:08:33.076000','https://picsum.photos/seed/picsum/800/450','原創','','','','Spring Boot ：從入門到放棄','2021-03-27 17:44:53.523000',0,53,1,'愉快的學習SpringBoot，這個Java的肥美框架，快速開發非常開心。'),
(52,'','','# Ninja','2021-03-26 21:13:13.665000','https://picsum.photos/seed/picsum/800/450','轉載','','','','從忍者到忍者程式碼','2021-03-27 17:40:25.526000',0,21,1,'如何寫出別人看不懂的程式碼一直是個重要的課題，像個忍者一樣，跟著本篇的教學走，幫助你成為一個忍者大師。'),
(59,'','','# 演算法','2021-03-27 23:33:47.808000','https://picsum.photos/seed/picsum/800/450','原創','','','','成為演算法之鬼 ：痛苦的學習演算法','2021-03-27 23:33:47.808000',0,54,1,'為什麼別人程式跑五秒你要跑半小時？你不覺得很奇怪嗎？現在就開始愉快的學習！'),
(60,'','','# 《*Building Maintainable Software, Java Edition 打造可維護軟體：編寫可維護程式碼的10項法則 （Java版）*》\r\n\r\n在圖書館看到這本書，也才一百多頁而已，看到出版商歐萊禮就翻了一下覺得不錯，就借回家來讀，第一次嘗試寫學習筆記，也是嘗試使用更好的學習方法，希望自己未來更強。\r\n\r\n> **筆記作者：葉高緯 Wei the Shinobi**\r\n\r\n# 1. 簡短的程式碼\r\n\r\n> 傻瓜也可寫出電腦能懂得程式碼，但優秀的工程師才能寫出人類能夠理解的程式碼 。	— Martin Fowler\r\n>\r\n\r\n- **程式碼單元的長度應在15行內。**\r\n\r\n## 1.1 好處\r\n\r\n- 容易測試\r\n- 容易分析\r\n- 容易複用\r\n\r\n## 1.2 重構技巧\r\n\r\n1. 提取方法：將一段很長的程式碼，提取出一部份拆分成新的方法。不僅好讀，還可實現程式碼複用。\r\n\r\n- 那如果遇到需要傳送很多區域變數的情況呢？拆分出來的新方法要傳一長串參數肯定很麻煩，這時我們需要另尋他法。\r\n\r\n2. 以物件方法取代方法：如果你要傳送一長串的變數，可以把某些要傳遞的區域變數，轉變成類別的私有欄位。就是提升作用域的意思。\r\n\r\n```java\r\nclass Something {\r\n   void doSomething(int x,String y,int a,int b, int c, int d){\r\n        // ...\r\n    }\r\n}\r\n```\r\n\r\n改寫成\r\n\r\n```java\r\nclass Something {\r\n    private int x;\r\n    private String y;\r\n    \r\n    Something(int x,String y) {\r\n        this.x = x;\r\n        this.y = y;\r\n    }\r\n    \r\n    void doSomething(int a,int b, int c, int d){\r\n        // ...\r\n    }\r\n}\r\n```\r\n\r\n## 1.3 討論\r\n\r\n1. 效能\r\n   - 實際上效能不會有太大的差別，而且兩害取其輕。\r\n2. 拆分程式碼難以閱讀\r\n   - 其實不會。\r\n\r\n#  2. 簡單的程式碼\r\n\r\n> 每個問題都是由一些小問題組成的。	— Martin Fowler\r\n>\r\n\r\n- **每個程式碼單元不超過4個邏輯分支點。**\r\n- **拆分，避免複雜的糾結。**\r\n- **分支越少，測試及修改能越簡單。**\r\n\r\n越多的分支，就有越高的**循環複雜度**，你需要測試的路徑分支就越多。\r\n\r\n## 2.1 switch case\r\n\r\n- 一長串的switch看起來無害，可讀性也很強，但是想要測試方法需要寫很多個的測試案例。\r\n\r\n  1. 替換成map，從map取值時再做出判斷。\r\n  2. 替換成多型。\r\n\r\n## 2.2 處理嵌套語句\r\n\r\n- 以衛述句取代嵌套條件式\r\n  - 識別不同狀況插入return，來替代嵌套的條件語句。\r\n  - 還可以再使用**提取方法**的技巧來拆分方法。\r\n\r\n## 2.3 討論\r\n\r\n1. 高複雜度無可避免？\r\n\r\n   - 複雜的知識領域未必需要複雜的實作，你還是可以建構簡單的技術方案，而這完全可以辦到。\r\n\r\n2. 拆分方法不會降低複雜度\r\n\r\n   > 將1個循環複雜度為15的方法拆成3個循環複雜度為5的方法不會降低整體的複雜度，這根本沒用。\r\n\r\n   - 的確，但會更容易測試和理解，新撰寫的單元測試也能更簡單。\r\n\r\n# 3. 不重複的程式碼\r\n\r\n> 排名第一的程式碼壞味道就是程式碼重複。	— Kent Beck 與 Martin Fowler，《*Bad Smells in Code*》\r\n\r\n- **禁止程式碼重複。**\r\n\r\n## 3.1 定義\r\n\r\n- 長度至少6行的一段相同程式碼，不包括空白和註解。\r\n\r\n> 複製就像技術債，將來要修改會很痛苦。\r\n\r\n# 4. 參數簡單的程式碼\r\n\r\n> 四處分散的相關資料應該被封裝成一個物件。	— Martin Fowler\r\n\r\n- 限制程式碼單元的參數**不超過4個**。\r\n- **將多個參數提取到class**來達成。\r\n- 較少的參數較容易理解與重複使用。\r\n\r\n## 4.1 解決方法\r\n\r\n二維或三維空間的參數，長長的一排在方法上，看了就不想讀了。\r\n\r\n- 我們可以**引進參數物件**：\r\n  - 寫一個內部類來攜帶參數，例如一個方法要傳正方體的xyz，就可以寫一個內部類正方體class。\r\n\r\n- **以物件方法取代方法**：\r\n  - 見**1.2 重構技巧**。\r\n\r\n# 5. 不同模組之間的關注點分離\r\n\r\n> 在既複雜又緊密耦合的系統中，意外無可避免。	— Charles Perrow 的意外理論（Normal Accidents）\r\n\r\n- **避免形成大型模組，達成模組之間的鬆散耦合。**\r\n- **不同職責不同模組，隱藏介面內部實作細節。**\r\n\r\n> 這裡的模組概念對應到物件導向語言（如Java）的類別。\r\n\r\n## 5.1 動機\r\n\r\n你是否有這樣的經驗，一個UserService的class，本來只有幾個服務，後來越加越多，只要跟user有關連的都丟進來，變的巨大難以維護…\r\n\r\n- 鬆散耦合的小模組容易維護。\r\n- 讓經驗不足的開發人員不會手足無措。\r\n\r\n## 5.2 解決方法\r\n\r\n1. 根據不同的關注點拆分\r\n   - 一個UserService可能有郵件相關、提醒或是封鎖，根據不同的功能拆分。\r\n2. 將特定實作隱藏在介面\r\n   - 舉例來說，一個相機有普通功能跟高階功能，你可以實作Camera，然後再實作HighLevelCamera繼承Camera。\r\n   - 僅使用Camera的話，不需要知道HighLevelCamera的實作方法。\r\n\r\n# 6. 以鬆散耦合的方式架構元件\r\n\r\n> 有兩種方式建構軟體設計：一種是簡單到明顯沒有缺陷，另一種是複雜到沒有明顯缺陷。	— C.A.R. Hoare\r\n\r\n- **頂層元件之間應該保持鬆散耦合。**\r\n- **盡量減少目前模組需要暴露給（被呼叫）其他元件之模組的程式碼數量。**\r\n- 此方針可提升**可維護性，因為獨立的元件有利於獨立的維護。**\r\n\r\n> - **元件 = 模組群**\r\n\r\n## 6.1 可維護性的調用\r\n\r\n- 正面：\r\n  - **內部調用是健康的**。元件裡的模組群內部調用。\r\n  - 傳出調用也是健康的。\r\n\r\n- 負面：\r\n  - 傳入調用。為其他元件提供功能性應該限制。修改傳入調用的程式碼可能會影響其他程式。\r\n  - 透傳程式碼。透過程式碼接收傳入，再傳出給其他元件，風險不小。\r\n\r\n## 6.2 討論\r\n\r\n一開始的系統很讚，但隨著時間可能有人違反原則，單向依賴變得混亂模糊。\r\n\r\n低度元件依賴讓分工更容易，因為緊密依賴要看其他團隊的臉色。\r\n\r\n低度元件依賴讓測試也變得容易，要弄一堆mock實在太麻煩了。\r\n\r\n透過**設計模式**可以幫你實現。\r\n\r\n- 反對意見：\r\n\r\n  - 因為相互糾纏無法修正：分析傳遞調用將邊界劃分清楚。\r\n  \r\n- 例如有大量傳入調用的模組可能表示它們承擔多重職責，可以劃分與拆解。\r\n  \r\n- 我知道這很重要，但我沒時間：你可以衡量維護成本，重點在於權衡。\r\n  \r\n- 透傳調用是需求：\r\n  \r\n  某些架構被設計出中間層，一個服務層收集請求然後打包給其他分層。存在不是問題，但應該分區傳入請求與傳出請求。\r\n  \r\n    - 不應該處理請求本身\r\n    - 不應該知道哪裡及如何處理請求\r\n\r\n# 7. 保持架構元件平衡\r\n\r\n> 建構封裝邊界是設計軟體架構的重要技巧。 — George H. Fairbanks，《*Just Enough Archiecture*》\r\n\r\n- 讓頂層元件的數量和尺寸維持平衡。\r\n- 良好的平衡能讓查詢與分析更容易。\r\n- 能夠更好分工。\r\n\r\n# 8. 保持小規模的程式碼基礎\r\n\r\n> 程式複雜度持續增加，直到超出維護人員的負荷。 — 電腦編程的第七條法則\r\n\r\n- 盡可能保持**小規模的程式碼基礎**\r\n- **小產品、小專案與小團隊是成功的要因**\r\n\r\n統計結果顯示，大型專案品質較差，**缺陷密度**較高。\r\n\r\n# 9. 自動化測試\r\n\r\n> 要想保持程式碼乾淨無慮，先讓測試進度條維持綠色。	— JUnit格言\r\n\r\n- 使用**測試框架**。\r\n- 自動化測試讓開發過程**可以預測**並**降低風險**。\r\n\r\n## 9.1 動機\r\n\r\n- 自動化測試可以反覆進行\r\n- 讓開發更有效率：盡量**在開發流程早期開始測試**，降低修正問題的成本。\r\n- 讓程式碼的行為可預測：避免出現打地鼠的問題。\r\n\r\n## 9.2 原則\r\n\r\n1. 一般或特殊情況都要測試：\r\n   - 快樂流程測試正常的情況。\r\n   - 不快樂流程測試不正常的情況或確定在測試中拋出特定例外。\r\n\r\n2. 像維護非測試程式碼一樣維護測試程式碼：\r\n   - 對系統程式碼進行修改，測試程式碼也會被影響。\r\n\r\n3. 獨立的測試：\r\n   - 每個測試都應該只測試一個功能。\r\n\r\n4. 覆蓋率在80%以上，幾乎跟產品程式碼差不多。\r\n\r\n# 10. 撰寫乾淨的程式碼\r\n\r\n> 專業開發者有責任撰寫簡潔的程式碼。 — Robert C. Martin\r\n\r\n- **簡潔的程式碼**。\r\n- **童軍守則**：離開營地時，要讓它比原先更乾淨。\r\n\r\n## 10.1 規則\r\n\r\n1. 不要留下單元層級的程式碼壞味道\r\n   \r\n   - 本書前四章的技巧，可以些許違反，但在程式碼**提交到版本控制之前**要修改好。\r\n   \r\n2. 不要撰寫不好的註解\r\n   \r\n   - 好的程式碼和命名足以說明這段在做什麼，不要有教條式的註解。\r\n   \r\n3. 不要再註解中撰寫程式碼\r\n   \r\n   - 對於新的開發人員是種干擾，版本控制會記錄程式碼的。\r\n   \r\n4. 別留下無用的程式碼\r\n\r\n   - 無法達到的程式碼、沒被使用的私有方法等等。\r\n\r\n5. 不要使用冗長的名稱\r\n\r\n6. 不要使用魔法常數\r\n\r\n   - 魔法常數是指在程式碼中沒有明確寫明意思的值，例如下方例子的65，應該明確定義。\r\n\r\n     ```java\r\n     if (age > 65) {\r\n         // ...\r\n     }\r\n     ```\r\n\r\n     修改成\r\n     \r\n     ```java\r\n     private static final int OLD_MAN_AGE = 65;\r\n     \r\n     if (age > OLD_MAN_AGE) {\r\n       // ...\r\n     }\r\n     ```\r\n     \r\n     \r\n\r\n7. 不要留下未正確處理的例外\r\n\r\n   - 總是捕捉例外，不要空的catch區塊。\r\n   - 捕捉特定例外，不要捕捉最抽象的。\r\n   - 將例外轉譯成通用訊息，否則使用者會困惑。\r\n\r\n\r\n\r\n\r\n','2021-03-27 23:49:10.936000','https://picsum.photos/seed/picsum/800/450','原創','','','','《打造可維護軟體：編寫可維護程式碼的10項法則》','2021-03-29 06:15:15.691000',0,54,1,'《打造可維護軟體：編寫可維護程式碼的10項法則 （Java版）》，在圖書館看到這本書，也才一百多頁而已，看到出版商歐萊禮就翻了一下覺得不錯，就借回家來讀，第一次嘗試寫學習筆記，也是嘗試使用更好的學習方法，希望自己未來更強。'),
(61,'','','# JVM\r\n\r\n> 筆記作者：葉高緯 Wei the Shinobi\r\n>\r\n> 參考資料：[【狂神说Java】JVM快速入门篇](https://www.bilibili.com/video/BV1iJ411d7jS)\r\n>\r\n> 延伸閱讀：《*深入理解 Java 虛擬機：JVM 高級特性與最佳實踐*》\r\n\r\n\r\n# 加載器與雙親委派\r\n\r\n\r\n加載器：\r\n\r\n\r\n- 根加載器\r\n- 擴展類加載器\r\n- 應用程式加載器\r\n\r\n雙親委派：\r\n\r\n- 先找根加載器，如果沒有\r\n- 找擴展類加載器，如果沒有\r\n- 找應用程式加載器（我們寫的程式）\r\n- 如果都沒有，ClassNotFoundException\r\n\r\n# Native 關鍵字\r\n\r\n1. 凡是帶了native關鍵字，說明Java的作用範圍達不到了，**調用底層C語言的庫**。\r\n2. 進入**本地方法棧**(native method stack) \r\n3. 調用**本地方法接口JNI**(native method interface)\r\n\r\nJNI作用：擴展Java的使用，融合不同的語言為Java所用。\r\n\r\nJava開闢了一個標記區域：native method stack，登記Native方法，\r\n\r\n在最終執行時，加載本地方法庫中的方法通過JNI。\r\n\r\n# 方法區\r\n\r\n方法區被所有線程共享，靜態變量、常量、類信息和常量池存在方法區中，\r\n\r\n但是**實例變量**存在**堆**中，和方法區無關。\r\n\r\nstatic, final, Class, 常量池\r\n\r\n# 棧 Stack\r\n\r\n線程等級\r\n\r\n先進後出\r\n\r\n# 堆 Heap\r\n\r\n一個JVM只有一個Heap，\r\n\r\nHeap記憶體的大小是可以調節的。\r\n\r\n類加載器讀取類文件後，把類、方法、常量、變量放到堆中，\r\n\r\n保存所有引用類型的真實對象。\r\n\r\n## 三個區域\r\n\r\n- 新生區\r\n  - 伊甸園\r\n  - 倖存區1\r\n  - 倖存區2\r\n- 老年區\r\n- 永久區（JDK 1.8後叫元空間）\r\n\r\nGC回收主要在伊甸區和老年區。\r\n\r\n假設記憶體滿了就會出現OOM(OutOfMemoryError)，\r\n\r\n### 新生區\r\n\r\n- 誕生和死亡的地方\r\n- 伊甸園：所有物件都在這new出來。\r\n- 沒被GC清除的物件會不斷往下移動，直到老年區，\r\n\r\n### 永久區\r\n\r\n用來存放JDK自身攜帶的Class物件。Interface元數據，存儲的是Java運行時的環境。\r\n\r\n不存在GC回收。\r\n\r\n關閉JVM就會釋放這個區域。\r\n\r\n- jdk 1.6 之前：永久代，常量池在方法區。\r\n- jdk 1.7 ：永久代，但是慢慢退化了，**去永久代**，方法區在堆中。\r\n- jdk 1.8之後：無永久代，常量池在元空間中。\r\n\r\n## JVM 記憶體參數\r\n\r\n```java\r\n-Xms1024m -Xmx1024m -XX:+PrintGCDetails\r\n```\r\n\r\n手動調整記憶體為1024MB，\r\n\r\n```java\r\n-XX:+PrintGCDetails\r\n```\r\n\r\n> 這一行可以打印出資訊。\r\n\r\n新生區和老年區的記憶體加起來就是JVM的記憶體。\r\n\r\n元空間在邏輯上存在，物理上不存在。\r\n\r\n# GC 垃圾回收\r\n\r\nGC並不是全部一次回收，大部分都是在新生區回收。\r\n\r\n- 伊甸園區\r\n- 倖存區(from , to)\r\n- 老年區\r\n\r\nGC分成兩種：輕GC(Partial GC)、重GC(Full GC)\r\n\r\n## 算法\r\n\r\n- 標記清除法\r\n- 標記整理\r\n- 複製算法\r\n\r\n### 複製算法\r\n\r\nGC在清除區域前，\r\n\r\n會先把區域內的物件複製到另一區，\r\n\r\n伊甸區會移去倖存區，\r\n\r\n倖存區有兩個，\r\n\r\n清除一個前就會先把物件複製到另一個，\r\n\r\n所以to和from倖存區並不是固定哪一個，\r\n\r\n誰是空的誰是to，\r\n\r\n**當一個物件經歷15次複製還存在**，\r\n\r\n就會進去老年區。\r\n\r\n- 好處：沒有記憶體碎片。\r\n- 壞處：浪費記憶體空間。\r\n\r\n物件存活率低時最好用。\r\n\r\n### 標記清除\r\n\r\n1. 掃瞄並標記物件\r\n2. 對沒有標記的物件進行清除\r\n\r\n- 好處：不需要額外的空間。\r\n- 壞處：兩次掃描嚴重浪費時間，會產生記憶體碎片。\r\n\r\n### 標記壓縮\r\n\r\n再優化，\r\n\r\n再次掃描並移動存活的物件，\r\n\r\n解決碎片化。\r\n\r\n## 總結\r\n\r\n效率：複製算法 > 標記清除 > 標記壓縮\r\n\r\n記憶體整齊度：複製算法 = 標記壓縮 > 標記清除\r\n\r\n記憶體利用率：標記壓縮 = 標記清除 > 複製算法\r\n\r\n沒有最好的演算法，只有最合適的。\r\n\r\nGC也被稱為分代收集算法。\r\n\r\n在年輕代使用複製算法，\r\n\r\n在老年代使用標記清除和標記壓縮。\r\n\r\n','2021-03-29 06:27:43.899000','https://picsum.photos/seed/picsum/800/450','原創','','','','Java 虛擬機','2021-03-29 06:27:43.899000',0,54,1,'Java虛擬機，你必須得了解它，就像是吃牛排要看過牛走路一樣。');

/*Table structure for table `t_blog_tags` */

DROP TABLE IF EXISTS `t_blog_tags`;

CREATE TABLE `t_blog_tags` (
  `blogs_id` bigint NOT NULL,
  `tags_id` bigint NOT NULL,
  KEY `FK5feau0gb4lq47fdb03uboswm8` (`tags_id`),
  KEY `FKh4pacwjwofrugxa9hpwaxg6mr` (`blogs_id`),
  CONSTRAINT `FK5feau0gb4lq47fdb03uboswm8` FOREIGN KEY (`tags_id`) REFERENCES `t_tag` (`id`),
  CONSTRAINT `FKh4pacwjwofrugxa9hpwaxg6mr` FOREIGN KEY (`blogs_id`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_blog_tags` */

insert  into `t_blog_tags`(`blogs_id`,`tags_id`) values 
(52,46),
(52,51),
(48,24),
(48,44),
(48,45),
(48,55),
(47,44),
(47,46),
(47,56),
(59,44),
(59,46),
(59,51),
(59,57),
(60,44),
(60,51),
(61,44),
(61,55);

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` bigint NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `blog_id` bigint DEFAULT NULL,
  `comment_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKke3uogd04j4jx316m1p51e05u` (`blog_id`),
  KEY `FKjt3xywsr7iscyfan44ul06v6a` (`comment_id`),
  CONSTRAINT `FKjt3xywsr7iscyfan44ul06v6a` FOREIGN KEY (`comment_id`) REFERENCES `t_comment` (`id`),
  CONSTRAINT `FKke3uogd04j4jx316m1p51e05u` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_comment` */

/*Table structure for table `t_tag` */

DROP TABLE IF EXISTS `t_tag`;

CREATE TABLE `t_tag` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_tag` */

insert  into `t_tag`(`id`,`name`) values 
(24,'Web'),
(43,'Android'),
(44,'學習筆記'),
(45,'Spring'),
(46,'教學'),
(51,'技術觀念'),
(55,'Java'),
(56,'Go'),
(57,'演算法'),
(58,'Python');

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`name`) values 
(21,'學習心得'),
(53,'程式開發'),
(54,'深度研究');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`avatar`,`create_time`,`email`,`nickname`,`password`,`type`,`update_time`,`username`) values 
(1,'/images/wei_the_shinobi.jpg','2021-03-13 18:47:29.000000','admin@email.com','Wei the Shinobi','e10adc3949ba59abbe56e057f20f883e',1,'2021-03-13 18:48:09.000000','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
