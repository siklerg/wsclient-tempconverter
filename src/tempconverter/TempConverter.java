package tempconverter;

import org.apache.axis.AxisFault;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

public class TempConverter {

    public static void main(String[] args) {

        try {
           // TemperatureConversionsLocator locator = new TemperatureConversionsLocator();
            URL url = new URL("http://webservices.daehosting.com/services/TemperatureConversions.wso");
            TemperatureConversionsSoapBindingStub stub = new TemperatureConversionsSoapBindingStub(url, null);

            BigDecimal fahrenheit = stub.celsiusToFahrenheit(BigDecimal.valueOf(100));
            BigDecimal celsius = stub.fahrenheitToCelsius(BigDecimal.valueOf(302));

            System.out.println("100 Celsius = "+fahrenheit+" Fahrenheit.");
            System.out.println("302 Fahrenheit = "+celsius+" Celsius.");
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
