SPOON_DIR="target/spoon-output/image"
REFERENCE_DIR="src/test/resources/"

#if reference dir doesn't exist, create it
if [ ! -d "$REFERENCE_DIR" ]; then
  mkdir -p $REFERENCE_DIR
fi

#############################
#loop through all screenshots
#############################

for SCREENSHOT in `find $SPOON_DIR/* | grep png | grep -v diff`
do
#echo "screenshot is at $SCREENSHOT"
REFERENCE="$REFERENCE_DIR`echo $SCREENSHOT| cut -c 27-`"
#echo "reference is at $REFERENCE"
SCREENSHOT_NAME=`echo $SCREENSHOT | tr "/" "_"`

#if there is no reference, copy screenshot as reference
if [ ! -f "$REFERENCE" ]; then
  mkdir -p `dirname $REFERENCE`
  #cp $SCREENSHOT $REFERENCE 
  NO_REFERENCE="1"
fi

#create a diff
compare $SCREENSHOT $REFERENCE -compose src $SPOON_DIR/diff-$SCREENSHOT_NAME 2>/dev/null

#automate answer
compare -metric AE -fuzz '10%' $SCREENSHOT $REFERENCE $SPOON_DIR/success-$SCREENSHOT_NAME 2>/dev/null
SUCCESS=$?
rm -f $SPOON_DIR/success-$SCREENSHOT_NAME

echo -n "`basename $SCREENSHOT`"
if [ "$NO_REFERENCE" = "1" ]
then 
  	echo " NO_REF"
else
  if [ "$SUCCESS" = "0" ]
  then
  	echo " OK"
        rm -f $SPOON_DIR/diff-$SCREENSHOT_NAME
  else
	echo " NOK"
  fi
fi

done
