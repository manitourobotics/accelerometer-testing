This Netbeans project is for testing the ADXL345 accelerometer through its outputs using the WPILIB with the ADXL345_I2C class and the I²C interface on the accelerometer.

# Requirements

* Netbeans(or an equivalent IDE/Workflow but a Netbeans project is included)
* The appropriate FIRST plugins
    * for WPILIB, etc
* A CRIO and a Digital Sidecar
* SmartDashboard(for seeing the output in realtime and for graphing the output)
* Optional
    * A drivetrain for real testing the acceleration of each axis(there is include code to do this, but it can be ignored)
    * A Joystick to rotate and move the drivetrain (you may need to configure the joystick axes inputs in the code)
    * Mounting and Aligning the Accelerometer for reliable

# Wiring

The accelerometer is using the I²C interface. Make sure the accelerometer is wired properly as so using the four pinouts on the right of the image below, as these pinouts are exclusively for the I²C interface. My accelerometer happens to be attached to a corresponding gyro, which is unrelated. Also, make sure that the wires are clamped down on a surface to prevent them falling out.

![I²C interface && Clamps](http://azrathud.com/data/accelerometer-images/clamp.png "Make sure the wires are clamped")


I used a random computer four pin computer wire to connect to the I²C pins on the Sidecaro.

![4 pin wire](http://www.azrathud.com/data/accelerometer-images/wire.png "4 Pin Head")

The second set of pins from the bottom(shown below) are not accessible using this class. From the ADXL345_I2C class javadoc, "This class alows access to a Analog Devices ADXL345 3-axis accelerometer on an I2C bus. This class assumes the default (not alternate) sensor address of 0x3A (8-bit address)." Don't ask me why the designers of this class didn't add an extra field for specifying in the constructor.

![Wiring location](http://www.azrathud.com/data/accelerometer-images/sidecar.png "4 Pins")

# Alignment

The XYZ labels on the accelerometer indicate what axes measure acceleration in what direction. If the accelerometer is to be used for practical purposes, then it probably should be mounted perpindicular to the ground with the X and Y axes parallel to the sides of the robot.

![accelerometer xyz axes](http://www.azrathud.com/data/accelerometer-images/xyz.png "XYZ axes")

# Graphing Output on SmartDashboard

On the SmartDashboard, one can right click on the text objects if they are editable(View>Editable) and rightclick on them(Change to...> LinePlot) to see the acceleration over time.

![accelerometer-graph](http://azrathud.com/data/accelerometer-images/graph.png)
