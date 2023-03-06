<h1>Java Documentation for<br> ConfigurationFile</h1>
The <b>`ConfigurationFile`</b> class provides a way to create and manage configuration files. It contains methods to read, write, and manipulate configuration data. The class allows users to create and manage files containing simple variables, and supports the ability to create and manipulate more complex data types like lists and arrays in the future.

Table of Contents
Class Variables
Constructor
Public Methods
isEmpty()
saveFile()
Private Methods
readFile()
writeFile()
Class Variables
REMOVE: a String constant representing a tab character that is used to remove tab characters from the configuration file.

RESET: a String constant representing a color code that resets console text color.

BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE: String constants representing color codes that are used to color console output.

file: a File object representing the configuration file.

data: a HashMap object containing the configuration data.

Constructor
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
