This Netbeans project is for testing the SDXL345 accelerometer through its outputs using the WPILIB with the ADXL345_I2C class and the I²C interface on the accelerometer.

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

The accelerometer is using the I²C interface. 

![I²C interface && Clamps](http://azrathud.com/data/accelerometer-images/clamp.png "Make sure the wires are clamped")
![4 pin wire](http://www.azrathud.com/data/accelerometer-images/wire.png "4 Pin Head")
![Wiring location](http://www.azrathud.com/data/accelerometer-images/sidecar.png "4 Pins")

# Alignment

![accelerometer xyz axes](http://www.azrathud.com/data/accelerometer-images/xyz.png "XYZ axes")

# Graphing output

![accelerometer-graph](http://azrathud.com/data/accelerometer-images/graph.png)

# Use
