# Imports the monkeyrunner modules used by this program
import sys, os

from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

def ensure_dir(f):
    d = os.path.dirname(f)
    if not os.path.exists(d):
        os.makedirs(d)
        
def main():
	print('start')
	# Connects to the current device, returning a MonkeyDevice object
	timeOut = 10;
	if len(sys.argv) >= 2:
		deviceName = sys.argv[1]
		device = MonkeyRunner.waitForConnection(timeOut, deviceName)
	else:
		deviceName = 'defaultDevice'
		device = MonkeyRunner.waitForConnection(timeOut)
	
	print(deviceName)
	
	# Installs the Android package. Notice that this method returns a boolean, so you can test
	# to see if the installation worked.
	device.installPackage('android-sample/target/android-sample-0.0.1-SNAPSHOT.apk')
	
	# sets a variable with the package's internal name
	package = 'com.octo.android.sample'
	
	# sets a variable with the name of an Activity in the package
	activity = 'com.octo.android.sample.ui.HelloAndroidActivity'
	
	# sets the name of the component to start
	runComponent = package + '/' + activity
	
	# Runs the component
	device.startActivity(component=runComponent)
	
	# Presses the Menu button
	device.press('KEYCODE_MENU', MonkeyDevice.DOWN_AND_UP)
	
	# Takes a screenshot
	result = device.takeSnapshot()
	
	# Writes the screenshot to a file
	screenshotName = 'android-sample/target/monkeyrunner/'+deviceName+'/monkeyrunner-shot1.png'
	ensure_dir(screenshotName)
	result.writeToFile(screenshotName,'png')
	
main()