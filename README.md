## SmartSearchBar

#### 简介
##### 使用Mybatis,Sevlet,Ajax开发一款仿百度的智能提示搜索框,添加Kotlin支持。

#### 环境配置
 - Java: 1.8
 - Gradle: 4.4.1
 - Tomcat: 9.0.0
 - Kotlin: 1.2.30
#### 开发工具: IntellJ IDEA

#### Gradle配置内容

    group 'com.lq'
    version '1.0-SNAPSHOT'
    
    apply plugin: 'java'
    apply plugin: 'kotlin'
    apply plugin: 'war'
    
    sourceCompatibility = 1.8
    
    repositories {
        mavenCentral()
    }
    
    dependencies {
        testCompile group: 'junit', name: 'junit', version: '4.11'
        testCompile group: 'junit', name: 'junit', version: '4.12'
    
        // servlet -3.1.0
        compile group: 'javax.servlet', name: 'javax.servlet-api', version: '3.1.0'
    
        // mybatis -3.4.5
        compile group: 'org.mybatis', name: 'mybatis', version: '3.4.4'
    
        // pagehelper -5.1.2
        compile group: 'com.github.pagehelper', name: 'pagehelper', version: '5.1.2'
    
        // 日志记录 -1.7.25
        compile group: 'org.slf4j', name: 'slf4j-simple', version: '1.7.25'
    
        // mysql -5.1.18
        compile group: 'mysql', name: 'mysql-connector-java', version: '5.1.18'
    
        // fastjson -1.2.46
        compile group: 'com.alibaba', name: 'fastjson', version: '1.2.46'
        compile "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"
    
    
    }
    buildscript {
        ext.kotlin_version = '1.2.30'
        repositories {
            mavenCentral()
        }
        dependencies {
            classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        }
    }
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }




#### 数据库设计


    SET FOREIGN_KEY_CHECKS=0;
    
    -- ----------------------------
    -- Table structure for message
    -- ----------------------------
    DROP TABLE IF EXISTS `message`;
    CREATE TABLE `message` (
      `ID` int(11) NOT NULL AUTO_INCREMENT,
      `COMMAND` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`ID`)
    ) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
    
    -- ----------------------------
    -- Records of message
    -- ----------------------------
    INSERT INTO `message` VALUES ('1', '查看');
    INSERT INTO `message` VALUES ('12', '查找');
    INSERT INTO `message` VALUES ('13', '看你');
    INSERT INTO `message` VALUES ('14', '查看你');
    INSERT INTO `message` VALUES ('15', '查一个');
    SET FOREIGN_KEY_CHECKS=1;


#### 项目展示
![](images/searchBox.gif)


