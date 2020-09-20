# Java-Properties-UTF8
The modification of java.util.Properties for UTF8 encoding.

The Properties class write data with encoding "8859-1", and display the character as \\u[Code Number] which characters not define in the encoding "8859-1", it is a trouble for me and those country that not use the "8859-1" encoding.

As most solution you can find on internet, you can read the properties file with the way if it contain UTF-8 characters:
```java
  Properties prop=new Properties();
  InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
	prop.load(isr);
```
You can load the UTF-8 characters correctly, but you will lost the correct characters after you store back value which user changed.

For fix the trouble, I read the source code of Properties of version Java8, I made a object named Props that extend the java.util.Properties for fix the trouble, it fully compatible the Properties object.

Notice:
  The modification just only for key=value pair format, it not change anything for xml format, it may not help you if you are searching for xml solution.
