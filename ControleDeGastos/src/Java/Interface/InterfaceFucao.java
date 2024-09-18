package Java.Interface;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InterfaceFucao {


    public Date converterData (String dataString) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dataString, formato);
        java.sql.Date dataSql = java.sql.Date.valueOf(localDate);

        return dataSql;
    }


}
