package tempconverter;

import org.apache.axis.AxisFault;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TempConverterTest {

    @Test
    public void testConverting() {
        try {
            // TemperatureConversionsLocator locator = new TemperatureConversionsLocator();
            URL url = new URL("http://webservices.daehosting.com/services/TemperatureConversions.wso");
            tempconverter.TemperatureConversionsSoapBindingStub stub =
                    new tempconverter.TemperatureConversionsSoapBindingStub(url, null);

            Integer fahrenheit = stub.celsiusToFahrenheit(BigDecimal.valueOf(100)).intValue();
            Integer celsius = stub.fahrenheitToCelsius(BigDecimal.valueOf(302)).intValue();

            assertEquals(212, fahrenheit);
            assertEquals(150, celsius);

        } catch (
                AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (
                RemoteException e) {
            e.printStackTrace();
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
