-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (76);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oj_table`
--

DROP TABLE IF EXISTS `oj_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oj_table` (
  `id` bigint NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `level` varchar(50) DEFAULT NULL,
  `description` varchar(4096) DEFAULT NULL,
  `templateCode` varchar(4096) DEFAULT NULL,
  `testCode` varchar(4096) DEFAULT NULL,
  `template_code` text,
  `test_code` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oj_table`
--

LOCK TABLES `oj_table` WRITE;
/*!40000 ALTER TABLE `oj_table` DISABLE KEYS */;
INSERT INTO `oj_table` VALUES (1,'a+b','0','??????a???b????????????a+b','class Solution  {    public int twoNum(int a,int b){}}','public static void main(String args[]) {Solution s=new Solution();if(s.twoNum(1,2)==3){   System.out.println(\"TestCase OK!\");}else{System.out.println(\"TestCase Fail!\");}}','class Solution  {    public int twoNum(int a,int b){}}','public static void main(String args[]) {Solution s=new Solution();if(s.twoNum(1,2)==3){   System.out.println(\"TestCase OK!\");}else{System.out.println(\"TestCase Fail!\");}}\n '),(2,'????????????','??????','???????????????????????? nums ???????????????????????? target?????????????????????????????? ??????????????? ?????? ?????? ??????????????????????????????????????????\n\n????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????\n\n???????????????????????????????????????\n\n \n\n?????? 1???\n\n?????????nums = [2,7,11,15], target = 9\n?????????[0,1]\n??????????????? nums[0] + nums[1] == 9 ????????? [0, 1] ???\n?????? 2???\n\n?????????nums = [3,2,4], target = 6\n?????????[1,2]\n?????? 3???\n\n?????????nums = [3,3], target = 6\n?????????[0,1]\n \n\n?????????\n\n2 <= nums.length <= 103\n-109 <= nums[i] <= 109\n-109 <= target <= 109\n??????????????????????????????\n\n??????????????????LeetCode???\n?????????https://leetcode-cn.com/problems/two-sum\n??????????????????????????????????????????????????????????????????????????????????????????????????????','class Solution {\n    public int[] twoSum(int[] nums, int target) {\n\n    }\n}','    public static void main(String[] args) {\n        Solution solution = new Solution();\n        int[] arr2 = {3,2,4};\n        int target2 = 6;\n        int[] result2 = solution.twoSum(arr2, target2);\n        if (result2.length == 2 && result2[0] == 1 && result2[1] == 2) {\n            System.out.println(\"TestCaseOK!\");\n        } else {\n            System.out.println(\"TestCaseFailed!\");\n        }\n    }\n','class Solution {\n     public int[] twoSum(int[] nums, int target) {\n \n     }\n }','public static void main(String[] args) {\n         Solution solution = new Solution();\n         int[] arr2 = {3,2,4};\n         int target2 = 6;\n         int[] result2 = solution.twoSum(arr2, target2);\n         if (result2.length == 2 && result2[0] == 1 && result2[1] == 2) {\n             System.out.println(\"TestCaseOK!\");\n         } else {\n             System.out.println(\"TestCaseFailed!\");\n         }\n     }\n ');
/*!40000 ALTER TABLE `oj_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog`
--

DROP TABLE IF EXISTS `t_blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_blog` (
  `id` bigint NOT NULL,
  `appreciation` bit(1) NOT NULL,
  `commentabled` bit(1) NOT NULL,
  `content` varchar(10000) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog`
--

LOCK TABLES `t_blog` WRITE;
/*!40000 ALTER TABLE `t_blog` DISABLE KEYS */;
INSERT INTO `t_blog` VALUES (51,_binary '',_binary '','<pre><code>          [TOC]\n</code></pre>\n<p>javase-&gt;Mysql-&gt;???????????????-&gt;javaWeb-&gt;Maven(1)-&gt;spring-&gt;springMVC-&gt;mybatis-&gt;Maven(2)</p>\n<p>-&gt;Linux-&gt;git-&gt;springBoot-&gt;mybatisPlus-&gt;redis-&gt;nginx-&gt;docker-&gt;springCloud</p>\n<p>-&gt;rabbitMQ-&gt;??????(????????????/????????????)</p>\n<p>JVM+JUC</p>\n<p>????????????CSDN ???????????????</p>\n','2023-01-26 01:33:05.000000','https://picsum.photos/800/450','??????',_binary '',_binary '',_binary '','java??????????????????','2020-01-26 05:48:15.104000',12,4,1,'??????????????????java??????????????????'),(53,_binary '\0',_binary '','<p>MySQL5.0.3??????varchar(n)?????????n???????????????</p>\n<p>MySQL5.0.3??????varchar(n)?????????n????????????????????????varchar???200????????????????????????????????????????????????200???</p>\n<p>varchar???????????????????????????\n????????????????????????????????????gbk?????????????????????2????????????????????????????????????65535/2 =32766??? ??????????????????utf8???????????????????????????3???????????????????????????????????? 65535/3 =21845??????????????????????????????????????????varchar????????????mediumtext???longtext,??????</p>\n<p>mysql&gt; create table test12(id int(10),context varchar(79000));\nQuery OK, 0 rows affected, 1 warning (0.03 sec)</p>\n<pre><code>mysql&gt; show create table test12;\n+--------+--------------------------------------------------------------------------------------------------------------------+\n| Table  | Create Table                                                                                                       |\n+--------+--------------------------------------------------------------------------------------------------------------------+\n| test12 | CREATE TABLE `test12` (\n  `id` int(10) DEFAULT NULL,\n  `context` mediumtext\n) ENGINE=InnoDB DEFAULT CHARSET=latin1 |\n+--------+--------------------------------------------------------------------------------------------------------------------+\n</code></pre>\n<p>1 row in set (0.01 sec)</p>\n<p>????????????????????????????????????????????????\n????????????????????????CSDN????????????????????????????????????????????????CC 4.0 BY-SA???????????????????????????????????????????????????????????????\n???????????????https://blog.csdn.net/qq_29232943/article/details/103198430</p>\n','2023-01-26 01:45:25.000000','https://picsum.photos/seed/picsum/800/450','??????',_binary '',_binary '\0',_binary '','Mysql varchar ????????????','2021-01-26 06:33:51.249000',6,22,1,'Mysql varchar??????????????????????????????'),(54,_binary '\0',_binary '','<p>So Semantic UI appears to the latest \'hot\' UI framework which I\'m impressed with; however, their dropdown isn\'t an implementation of the HTML \'select\' and \'option\' tags but instead custom. For my project, I\'m using AngularJS which is phenomenal JavaScript MVW framework.</p>\n<p>How can I integrate AngularJS select ng-option with Semantic UI\'s dropdown? I\'m not much of a JS pro. Here\'s the JSfidde: http://jsfiddle.net/fMUy3/</p>\n<pre><code>&lt;!doctype html&gt;\n</code></pre>\n<html ng-app=\"App\">\n<pre><code>&lt;body ng-controller=&quot;MainCtrl&quot;&gt;\n        &lt;h3&gt;Option 1 (standard)&lt;/h3&gt;\n<pre><code>&amp;lt;select ng-model=&amp;quot;selectedItem&amp;quot; ng-options=&amp;quot;c as (c.id + \' - \' + c.name) for c in containers&amp;quot;&amp;gt;\n    &amp;lt;option value=&amp;quot;&amp;quot;&amp;gt;-- Pick A Container --&amp;lt;/option&amp;gt;\n&amp;lt;/select&amp;gt;\n&amp;lt;br&amp;gt;ID: {{selectedItem.id}}\n&amp;lt;br&amp;gt;Name: {{selectedItem.name}}\n &amp;lt;h3&amp;gt;&amp;lt;a href=&amp;quot;http://semantic-ui.com/modules/dropdown.html&amp;quot;&amp;gt; Semantic UI Dropdown&amp;lt;/a&amp;gt;&amp;lt;/h3&amp;gt;\n\n&amp;lt;div class=&amp;quot;ui selection dropdown &amp;quot;&amp;gt;\n    &amp;lt;input name=&amp;quot;id&amp;quot; type=&amp;quot;hidden&amp;quot; value=&amp;quot;0&amp;quot;&amp;gt;\n    &amp;lt;div class=&amp;quot;text&amp;quot;&amp;gt;-- Pick A Container --&amp;lt;/div&amp;gt;  &amp;lt;i class=&amp;quot;dropdown icon&amp;quot;&amp;gt;&amp;lt;/i&amp;gt;   \n    &amp;lt;div class=&amp;quot;menu transition hidden&amp;quot;&amp;gt;\n        &amp;lt;div class=&amp;quot;item active&amp;quot;&amp;gt;-- Pick A Container --&amp;lt;/div&amp;gt;\n        &amp;lt;div data-value=&amp;quot;{{container.id}}&amp;quot; class=&amp;quot;item&amp;quot; ng-repeat=&amp;quot;container in containers&amp;quot;&amp;gt;{{container.name}}&amp;lt;/div&amp;gt;\n    &amp;lt;/div&amp;gt;\n</code></pre>\n<p>&lt;/body&gt;\n</code></pre></p>\n</html>\n```javascript\nJavaScript:\n<p>var app = angular.module(\'App\', []);</p>\n<p>app.controller(\'MainCtrl\', function($scope) {\n$scope.containers = [\n{id: 1, name: \'Box1\'},\n{id: 2, name: \'Box2\'},\n{id: 3, name: \'Box3\'}];</p>\n<p>//$scope.selectedItem = $scope.containers[0];\n});</p>\n<p>$(\'.ui.dropdown\').dropdown();</p>\n<pre><code>Much appreciated!\n[??????](https://stackoverflow.com/questions/20559120/using-angularjs-select-ng-options-with-semantic-uis-dropdown &quot;??????&quot;)???????????????\n<p></code></pre></p>\n','2023-01-26 02:36:53.000000','https://picsum.photos/seed/picsum/800/450','??????',_binary '',_binary '',_binary '','sematic ui dropdown using','2022-01-26 06:33:26.724000',6,19,1,'?????????StackOverflow??????????????? semantic ui drop down?????????????????????'),(59,_binary '',_binary '','/**\r\n *  ??? ??????\r\n *      ?????????????????? -- ???????????????\r\n *  ??? ??????\r\n *      root?????????????????????????????????\r\n *      ptmp???????????????????????????\r\n *  ????????????\r\n *      ???\r\n **/\r\n\r\n    void post_thread_Older_byPrevNode(BiTNode *root)\r\n    {\r\n        if (root == NULL)\r\n            goto END;\r\n    \r\n        /**\r\n         *  ???????????????????????????????????? ?????? ?????????????????????\r\n         *  ????????????????????????????????????????????????????????????????????????\r\n         */\r\n        unsigned char buf[128] = {0};\r\n    	int i = 0, j = 0;\r\n        while (root)\r\n        {\r\n            buf[i] = root->data;\r\n            root = post_thread_prevNode(root);\r\n            i++;\r\n        }\r\n    \r\n        for (j = i; j > 0; j--)\r\n            printf(\"%c \", buf[j - 1]);\r\n    \r\n    END:\r\n        printf(\"\\n\");\r\n        return;\r\n    }\r\n\r\n\r\n    void post_thread(BiTNode *root, BiTNode **ptmp)\r\n    {\r\n        if ((root == NULL)) goto END;\r\n    \r\n        post_thread(root->lchild, ptmp);\r\n        post_thread(root->rchild, ptmp);\r\n    \r\n        if (root->lchild == NULL)\r\n        {\r\n            root->lchild = *ptmp;\r\n            root->lTag = 1;\r\n        }\r\n        if (*ptmp != NULL && (*ptmp)->rchild == NULL)\r\n        {\r\n            (*ptmp)->rchild = root;\r\n            (*ptmp)->rTag = 1;\r\n        }\r\n        (*ptmp) = root;\r\n    \r\n    END:\r\n        return;\r\n    }\r\n\r\n/**\r\n *  ??? ??????\r\n *      ??????????????????????????????????????? \r\n *  ??? ??????\r\n *      root?????????????????????\r\n *  ????????????\r\n *      ??????????????????????????????\r\n *      ?????????NULL\r\n **/\r\n\r\n\r\n    BiTNode *post_thread_prevNode(BiTNode *root)\r\n    {\r\n        BiTNode *ret = NULL;\r\n    \r\n        if (root == NULL)\r\n            goto END;\r\n    \r\n        // ?????? lTag ??? 1, ??????????????????????????????\r\n        if (root->lTag == 1)\r\n            ret = root->lchild;\r\n        // ??????????????????????????? rTag ?????? 1, ?????? rchild ???????????????????????????\r\n        else if (root->rchild && root->rTag != 1)\r\n            ret = root->rchild;\r\n        // ?????? rTag ??? 0, ???????????? rTag ???0??? ?????? rchild ???????????????????????????\r\n        // ????????????????????????????????????????????????????????????????????????????????????????????????????????????\r\n        // ????????????????????????????????????\r\n        else if (root->lTag == 0 && root->rTag == 1)\r\n            ret = root->lchild;\r\n        else\r\n            ret = root->lchild;\r\n    \r\n    END:\r\n        return ret;\r\n    }\r\n\r\n/**\r\n *  ??? ??????\r\n *      ???????????????????????? - ??????????????????\r\n *  ??? ??????\r\n *      root??????????????????????????????????????????\r\n *  ????????????\r\n *      ???\r\n **/\r\n\r\n\r\n    void post_thread_Older_byPrevNode(BiTNode *root)\r\n    {\r\n        if (root == NULL)\r\n            goto END;\r\n    \r\n        /**\r\n         *  ???????????????????????????????????? ?????? ?????????????????????\r\n         *  ????????????????????????????????????????????????????????????????????????\r\n         */\r\n        unsigned char buf[128] = {0};\r\n    	int i = 0, j = 0;\r\n        while (root)\r\n        {\r\n            buf[i] = root->data;\r\n            root = post_thread_prevNode(root);\r\n            i++;\r\n        }\r\n    \r\n        for (j = i; j > 0; j--)\r\n            printf(\"%c \", buf[j - 1]);\r\n    \r\n    END:\r\n        printf(\"\\n\");\r\n        return;\r\n    }\r\n\r\n','2023-01-26 13:14:07.000000','https://picsum.photos/seed/picsum/800/450','??????',_binary '',_binary '',_binary '\0','???????????????','2023-01-27 02:51:07.316000',16,29,1,'??????????????????????????????????????????????????????');
/*!40000 ALTER TABLE `t_blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_tags`
--

DROP TABLE IF EXISTS `t_blog_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_blog_tags` (
  `blogs_id` bigint NOT NULL,
  `tags_id` bigint NOT NULL,
  KEY `FK5feau0gb4lq47fdb03uboswm8` (`tags_id`),
  KEY `FKh4pacwjwofrugxa9hpwaxg6mr` (`blogs_id`),
  CONSTRAINT `FK5feau0gb4lq47fdb03uboswm8` FOREIGN KEY (`tags_id`) REFERENCES `t_tag` (`id`),
  CONSTRAINT `FKh4pacwjwofrugxa9hpwaxg6mr` FOREIGN KEY (`blogs_id`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_tags`
--

LOCK TABLES `t_blog_tags` WRITE;
/*!40000 ALTER TABLE `t_blog_tags` DISABLE KEYS */;
INSERT INTO `t_blog_tags` VALUES (51,44),(51,50),(51,57),(54,44),(54,50),(54,56),(53,49),(53,50),(59,50),(59,58);
/*!40000 ALTER TABLE `t_blog_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comment`
--

DROP TABLE IF EXISTS `t_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_comment` (
  `id` bigint NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `blog_id` bigint DEFAULT NULL,
  `parent_comment_id` bigint DEFAULT NULL,
  `admin_comment` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKke3uogd04j4jx316m1p51e05u` (`blog_id`),
  KEY `FK4jj284r3pb7japogvo6h72q95` (`parent_comment_id`),
  CONSTRAINT `FK4jj284r3pb7japogvo6h72q95` FOREIGN KEY (`parent_comment_id`) REFERENCES `t_comment` (`id`),
  CONSTRAINT `FKke3uogd04j4jx316m1p51e05u` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment`
--

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
INSERT INTO `t_comment` VALUES (61,'/images/avatar.png','????????????????????????','2023-01-26 14:33:12.231000','777777777@qq.com','ttccl',59,NULL,_binary '\0'),(62,'/images/avatar.png','??????????????????','2023-01-26 14:33:57.194000','777777778@qq.com','tt',59,61,_binary '\0'),(63,'/images/avatar.png','ceshi','2023-01-26 15:30:04.423000','ceshi@163.com','ceshi',59,62,_binary '\0'),(64,'/images/avatar.png','ceshi','2023-01-26 15:30:30.807000','ceshi1@163.com','ceshi1',59,NULL,_binary '\0'),(65,'/images/avatar.png','ceshi1','2023-01-26 15:33:48.600000','ceshi1@163.com','ceshi1',59,62,_binary '\0'),(66,'/images/avatar.png','??????','2023-01-26 15:36:24.134000','xiaobai@163.com','xiaobai',59,NULL,_binary '\0'),(67,'/images/avatar.png','????????????','2023-01-26 15:52:57.822000','whs@163.com','whs',59,NULL,_binary ''),(68,'/images/avatar.png','.......','2023-01-26 15:53:17.418000','whs@163.com','whs',59,67,_binary ''),(69,'/images/avatar.png','.....','2023-01-26 15:53:27.754000','whs@163.com','whs',59,63,_binary ''),(70,'/images/avatar.png','???','2023-01-26 15:53:42.680000','whs@163.com','whs',59,64,_binary ''),(71,'/images/avatar.png','????????????','2023-01-26 15:54:12.053000','777777777@qq.com','whs',53,NULL,_binary ''),(72,'/images/avatar.png','????????????????????????','2023-01-27 02:28:18.462000','whs@163.com','whs',51,NULL,_binary ''),(73,'/images/avatar.png','whs','2023-01-27 02:37:13.786000','box@163.com','whs',51,NULL,_binary ''),(74,'https://fastly.picsum.photos/id/870/200/300.jpg?blur=2&grayscale&hmac=ujRymp644uYVjdKJM7kyLDSsrqNSMVRPnGU99cKl6Vs','????????????','2023-01-27 02:39:36.360000','223@163.com','whs',53,71,_binary ''),(75,'/images/avatar.png','......','2023-01-27 02:40:03.454000','223@163.com','whs1',53,71,_binary '\0');
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_tag`
--

DROP TABLE IF EXISTS `t_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_tag` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_tag`
--

LOCK TABLES `t_tag` WRITE;
/*!40000 ALTER TABLE `t_tag` DISABLE KEYS */;
INSERT INTO `t_tag` VALUES (44,'??????'),(45,'??????'),(46,'??????'),(47,'??????'),(48,'??????'),(49,'????????????'),(50,'??????'),(56,'??????'),(57,'????????????'),(58,'c++');
/*!40000 ALTER TABLE `t_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_type`
--

DROP TABLE IF EXISTS `t_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_type` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_type`
--

LOCK TABLES `t_type` WRITE;
/*!40000 ALTER TABLE `t_type` DISABLE KEYS */;
INSERT INTO `t_type` VALUES (1,'????????????'),(2,'????????????'),(4,'java'),(5,'c#'),(6,'c++/c'),(7,'PHP'),(8,'Python'),(9,'KafKa'),(10,'SpringBoot'),(11,'SSM'),(12,'????????????'),(13,'redis'),(14,'SpringCloud'),(15,'Web??????'),(16,'RabbitMQ'),(17,'golang'),(18,'PS/PR'),(19,'??????'),(20,'?????????'),(21,'?????????'),(22,'??????????????????'),(23,'?????????????????????'),(24,'Spring Security'),(25,'????????????'),(26,'?????????'),(27,'??????'),(28,'Spring'),(29,'??????'),(30,'?????????????????????'),(31,'???????????????'),(32,'JPA'),(33,'??????'),(34,'?????????'),(35,'????????????');
/*!40000 ALTER TABLE `t_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'https://fastly.picsum.photos/id/870/200/300.jpg?blur=2&grayscale&hmac=ujRymp644uYVjdKJM7kyLDSsrqNSMVRPnGU99cKl6Vs','2023-01-24 17:45:00.000000','1648140804@qq.com','whs','421adc9807c779e90742a45c3fe67e23',1,'2023-01-24 17:45:00.000000','weihaisang','???????????????weihaisang?????????????????????????????????????????????');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-28 21:39:51
