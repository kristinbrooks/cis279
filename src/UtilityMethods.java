/*************************************************************************
 *  Program : UtilityMethods.java
 *  Purpose : To Provide utility methods that any program may use.
 *  Author  : F DAngelo
 *  Date    : September 23, 2015
 *
 *************************************************************************/

public class UtilityMethods
{

	public static double round( double valueToRound, int numberOfDecimalPlaces)
	{
		valueToRound *= Math.pow( 10, numberOfDecimalPlaces);

		int roundedValueInt = (int) valueToRound ;

		double roundedValueDbl = (double) roundedValueInt / Math.pow( 10, numberOfDecimalPlaces);

		return roundedValueDbl;
	}
}