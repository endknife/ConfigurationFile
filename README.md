<h1>Java Documentation for<br> ConfigurationFile</h1>
The <b>`ConfigurationFile 1.02`</b> class provides a way to create and manage configuration files. It contains methods to read, write, and manipulate configuration data. The class allows users to create and manage files containing simple variables, and supports the ability to create and manipulate more complex data types like lists.


<h2>What is new</h2>

<ul>
  <li><h4>Version 1.0 Beta 13/03/2023</h4></li>
  <ul>
    <li>Optimisation of code</li>
    <li>Mor readable code</li>
  </ul>
  <li><h4>Version 0.9 03/06/23</h4></li>
  <ul>
    <li>Arrays completely added</li>
    <li>Some optimisations</li>
    <li>Added example.yml</li>
  </ul>
</ul>


<h2>Table of Contents</h2>

<ul>
  <li><h4>1. Class Variables</h4></li>
  <li><h4>2. Constructors</h4></li>
  <li><h4>3. Public Methods</h4></li>
  <ul>
    <li><h5>1. add(String path, String value)</h5></li>
    <li><h5>2. add(String path, String[] array)</h5></li>
    <li><h5>3. getString(String path)</h5></li>
    <li><h5>4. getArray(String path)</h5></li>
    <li><h5>5. getArray(String path, int value)</h5></li>
    <li><h5>6. modifyString(String path, String value)</h5></li>
    <li><h5>7. deleteString(String path)</h5></li>
    <li><h5>8. deleteAll()</h5></li>
    <li><h5>9. saveFile()</h5></li>
    <li><h5>10. isEmpty()</h5></li>
  </ul>
  <li><h4>4. Private Methods</h4></li>
  <ul>
    <li><h5>1. readFile()</h5></li>
    <li><h5>2. writeFile()</h5></li>
  </ul>
</ul>


<h2>Class Variables</h2>
<ul>
  <li>REMOVE: a String constant representing a tab character that is used to remove tab characters from the configuration file.</li>
  <li>RESET: a String constant representing a color code that resets console text color.</li>
  <li>BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE: String constants representing color codes that are used to color console output.</li>
  <li>file: a File object representing the configuration file.</li>
  <li>data: a HashMap object containing the configuration data.</li>
</ul>
<br>


<h2>Constructor</h2>
The ConfigurationFile constructor takes a single parameter, which is the path to the configuration file. It creates a new configuration file if one does not already exist, and reads in any data that is present in the file.
