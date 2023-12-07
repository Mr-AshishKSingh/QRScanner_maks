
![alt text](QRScanner_maks\Img\image.png "Optional title")

# QR Code Reader

This code is a QR code reader implemented in Java using the ZXing library. It provides a graphical user interface (GUI) for scanning and decoding QR codes.

## How it works

The code snippet provided is part of a larger Java class that handles the QR code scanning functionality. Here's a breakdown of the important parts:

1. The code starts by declaring a `Result` object and a `BufferedImage` object, both initially set to `null`.

2. It checks if the QR code scanner, represented by the `wc` object, is open. If it is, it proceeds to the next step. Otherwise, it continues to the next iteration of the loop.

3. Inside the loop, it retrieves an image from the QR code scanner using the `getImage()` method. If the image is `null`, it continues to the next iteration of the loop.

4. It creates a `LuminanceSource` object from the retrieved image using the `BufferedImageLuminanceSource` class.

5. It creates a `BinaryBitmap` object from the `LuminanceSource` object using the `HybridBinarizer` class.

6. It attempts to decode the QR code using the `MultiFormatReader` class. If a QR code is successfully decoded, the result is stored in the `result` object.

7. If the `result` object is not `null`, it sets the text of a text field (`resultfield`) in the GUI to the decoded QR code text.

8. The loop continues indefinitely, scanning for QR codes until the program is terminated.

## Usage

To use this QR code reader, you need to have the ZXing library added to your Java project. You can find the library and its documentation at [ZXing GitHub repository](https://github.com/zxing/zxing).

Once you have the library set up, you can instantiate an object of the `ReadQR` class and call its `run()` method to start scanning for QR codes. The decoded QR code text will be displayed in the GUI.

## Dependencies

This code relies on the following dependencies:
- ZXing library: [https://github.com/zxing/zxing](https://github.com/zxing/zxing)
- ZXing core jar file: [https://github.com/zxing/zxing/releases](https://github.com/zxing/zxing/releases)
- ZXing javase jar file: [https://github.com/zxing/zxing/releases](https://github.com/zxing/zxing/releases)


## JAR FILES USED ARE






- core-3.4.1.jar
- javase-3.4.1.jar
- bridj-0.7.0.jar 
- bridj-0.6.2-windows-only.jar
- jai-imageio-core-1.4.0.jar
- jcommander-1.72.jar
- log4j-core-2.21.1.jar
- mysql-connector-java
- slf4j-api-2.0.9
- sql
- webcam-capture-0.3.12



 * The following JAR files are included in the project:
 * 
 * - core-3.4.1.jar: This JAR file contains the core functionality of the project.
 * 
 * - javase-3.4.1.jar: This JAR file provides the Java SE implementation for the project.
 * 
 * - bridj-0.7.0.jar: This JAR file is used for native interop with C libraries.
 * 
 * - bridj-0.6.2-windows-only.jar: This JAR file is a Windows-only version of the BridJ library.
 * 
 * - jai-imageio-core-1.4.0.jar: This JAR file provides core functionality for the Java Advanced Imaging (JAI) library.
 * 
 * - jcommander-1.72.jar: This JAR file provides a command-line argument parsing framework.
 * 
 * - log4j-core-2.21.1.jar: This JAR file provides core functionality for the Log4j logging framework.
 * 
 * - mysql-connector-java: This JAR file contains the MySQL Connector/J driver for connecting to a MySQL database.
 * 
 * - slf4j-api-2.0.9: This JAR file provides the API for the Simple Logging Facade for Java (SLF4J) framework.
 * 
 * - sql: This JAR file contains the SQL API for working with databases.
 * 
 * - webcam-capture-0.3.12: This JAR file provides functionality for capturing images from a webcam.
 



## License

This code is released under the [MIT License](https://opensource.org/licenses/MIT).





