package cl.corona.maestroCostos.util;

import cl.corona.maestroCostos.model.maestroCostos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class utility {
    private static final Logger LOG = LoggerFactory.getLogger(utility.class);

    private static final String dmySlashFormat = "dd/MM/yyyy";



    private utility() {
        throw new IllegalStateException("This is an Utility class. Is not meant to be instantiated");
    }

    public static Integer convertToInt(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).intValue();
        } else if (obj instanceof String) {
            return Integer.valueOf((String) obj);
        }
        return 0;
    }

    public static void writeInFileFull(List<maestroCostos> reportes, String path) {

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String monthReport = df.format(new Date());

        try {
            FileWriter fileWriter1 = new FileWriter(path + "MAESTRO_COSTOS_" + monthReport + ".csv");
            fileWriter1.write("INNER_PACK_ID;AUDIT_NUMBER;CST_TYPE_ID;PRD_LVL_CHILD;PRD_LVL_NUMBER;CST_COST;INNER_PK_TECH_KEY;DATE_CREATED;DOWNLOAD_DATE_1;DOWNLOAD_DATE_2;CST_KEY;CALDAT;FECHA_PROCESO;ID_USUARIO;NOMBRE_ARCHIVO;FECHA_INSERSION\n");
            for (maestroCostos report : reportes) {
                fileWriter1.write(
                        report.getInner_pack_id() + ";" +  report.getAudit_number() + ";" +  report.getCst_type_id() + ";" +
                                report.getPrd_lvl_child() + ";" +  report.getPrd_lvl_number() + ";" +  report.getCst_cost() + ";" +
                                report.getInner_pk_tech_key() + ";" +  report.getDate_created() + ";" +  report.getDownload_date_1() + ";" +
                                report.getDownload_date_2() + ";" +  report.getCst_key() + ";" +  report.getCaldat() + ";" +
                                report.getFecha_proceso() + ";" +  report.getId_usuario() + ";" +  report.getNombre_archivo() + ";" +
                                report.getFecha_insercion() + "\n");
            }
            fileWriter1.close();

        } catch (IOException e) {
            LOG.error("Problems when writing full file. " + e.getMessage());
        }
    }
}
