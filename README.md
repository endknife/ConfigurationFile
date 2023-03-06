<h1>Java Documentation for<br> ConfigurationFile</h1>
The <b>`ConfigurationFile 1.02`</b> class provides a way to create and manage configuration files. It contains methods to read, write, and manipulate configuration data. The class allows users to create and manage files containing simple variables, and supports the ability to create and manipulate more complex data types like lists.
<br>
<h2>What is new</h2>


<ul>
  <li><h4>Verson 1.02 03/06/23</h4></li>
  <ul>
  <li>Arrays completely added</li>
</ul>
</ul>


<br>
<h2>Table of Contents</h2>
<ul>
  <li><h4>1. Class Variables</h4></li>
  <li><h4>2. Constructors</h4></li>
  <li><h4>3. Public Methods</h4></li>
  <ul>
    <li><h5>1. isEmpty()</h5></li>
    <li><h5>2. saveFile()</h5></li>
  </ul>
  <li><h4>4. Private Methods</h4></li>
  <ul>
    <li><h5>1. readFile()</h5></li>
    <li><h5>2. writeFile()</h5></li>
  </ul>
</ul>
<br>

<h2>Class Variables</h2>
<ul>
  <li>REMOVE: a String constant representing a tab character that is used to remove tab characters from the configuration file.</li>
  <li>RESET: a String constant representing a color code that resets console text color.</li>
  <li>BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE: String constants representing color codes that are used to color console output.</li>
  <li>file: a File object representing the configuration file.</li>
  <li>data: a HashMap object containing the configuration data.</li>
</ul>

<h2>Constructor</h2>
The ConfigurationFile constructor takes a single parameter, which is the path to the configuration file. It creates a new configuration file if one does not already exist, and reads in any data that is present in the file.

java
Copy code
ConfigurationFile(String path)
Public Methods
is-Empty()
The isEmpty() method returns a boolean value indicating whether the configuration file is empty.

java
Copy code
public boolean isEmpty()
saveFile()
The saveFile() method writes any configuration data that is currently stored in memory to the configuration file. This method should be called before the program exits to ensure that any changes made to the configuration data are saved.

java
Copy code
public void saveFile()
Private Methods
readFile()
The readFile() method reads the configuration file line by line and saves the data in a HashMap object. Each line of the file represents either a variable or an object, and is stored as a key-value pair in the HashMap. If an object is encountered, the method updates the current path to include the object name, so that subsequent variables are added as attributes of the object.

java
Copy code
private void readFile()
writeFile()
The writeFile() method writes the configuration data stored in the HashMap object to the configuration file. The method iterates over each key-value pair in the HashMap and writes them to the file in the appropriate format.

java
Copy code
private void writeFile()
