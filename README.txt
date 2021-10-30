This is for Group 50's CS2212B final project.

---------------------------------------------

Steps to start the program:

1. Simply double left-click the executable.

Steps to start the program (in Eclipse):

1. Clone/download the project file from the website (presumably OWL)

1.1. Ensure that countries.txt, CountryList.txt and users.txt are present in the folder.

2. Using an appropriate IDE (Eclipse for ease of use)

3. Import/Open the project file (on Eclipse from toolbar menu->File->Open Projects From File System).
	3a. Browse to the directory where the project files are located (click on Directory).
	3b. Press Finish to add it to your work space.
	3c. You might have to re/set the classes path.

4. Run the program through the IDE.

Alternatively:

1. Clone/download the project file from the website (presumably OWL)

2. Copy the classes and .txt files present in the project file, into a file (location is determined by the user).

3. Using the IDE, import/open the project file (file created in step 1) (check step (3) above).
	3a. Browse to the directory where the project files are located (click on Directory).
	3b. Press Finish to add it to your work space.
	3c. You might have to import/use the jfreechart[version].jar & gson[version].jar files
		3d. Attempt to run the program which might crash given that 3b. is required, if the user is using Eclipse, it should
	    	    highlight the error (attempting to use a method from an unimplemented library), hovering over gson/jfreechart import
	    	    calls in some of the classes (PieChart for example) would bring over options to fix these errors: click on fix 
	    	    project setup and click on "Add archive 'jfreechart[version].jar..." then OK, and similarly should be done to gson.
		3e. Alternatively to 3c. You can add the .jar files manually from the toolbar menu in Eclipse (Run->Run Configurations)
	    	    then click on dependencies, then add External JAR files.

4. Run the program through the IDE.

---------------------------------------------

After starting the program:

1. The default country is Canada.

2. The user should enter their password and username (in a textfile included with the project).

3. If successful, the user should enter the main program.

4. The user can then interact with the interface, add and remove charts by pressing the (+) and (-) buttons

	without having to press recalculate.

5. The user can choose the year, or/and the analysis type, or/and choose the year range desired.

6. The user should press recalculate after step 5 to get their desired results.