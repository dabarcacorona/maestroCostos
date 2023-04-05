package cl.corona.maestroCostos.scheduler;

import cl.corona.maestroCostos.dao.maestroCostosDao;
import cl.corona.maestroCostos.model.maestroCostos;
import cl.corona.maestroCostos.util.utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class scheduledTasks {
    private static final Logger LOG = LoggerFactory.getLogger(scheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Value("${carpeta.baja}")
    private String download;

    @Value("${separador.carpetas}")
    private String separador;

    @Autowired
    private maestroCostosDao dao;

    @Scheduled(cron = "${cron.expression}")
    public void scheduledLog() throws InterruptedException {
        LOG.info("Ejecución Maestro Costos", dateTimeFormatter.format(LocalDateTime.now()));

        String strDir = System.getProperty("user.dir");
        //LOG.info("strDir (user.dir) = ({})", strDir);

        final String path = strDir + separador + download + separador;

        // Date exceptions
        LocalDate today = LocalDate.now();
        int count = 0;

        try {

            List<maestroCostos> reporte = dao.getReport();
            utility.writeInFileFull(reporte, path);

        } catch (InvalidDataAccessResourceUsageException e) {
            LOG.error("{}: Ocurrio un error al momento de rescatar los manifiestos diarios: ", e);
            return;
        }

        LOG.info("Fin ejecución", dateTimeFormatter.format(LocalDateTime.now()));

    }
}
