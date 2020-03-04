package com.asierg.kafka;

import com.asierg.kafka.dto.MongoDataDTO;
import com.asierg.kafka.dto.SchemaDTO;
import com.asierg.kafka.producer.Sender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {

    private final Sender sender;

    public KafkaApplication(Sender sender) {
        this.sender = sender;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        SchemaDTO schemaDTO = new SchemaDTO();
        schemaDTO.setOptional(false);
        schemaDTO.setType("string");
        MongoDataDTO mongoDataDTO=new MongoDataDTO();
        mongoDataDTO.setSchemaDTO(schemaDTO);
//        mongoDataDTO.setPayload("Document{{_id=Document{{_data=825E5F909B000000022B022C0100296E5A100431B385CC20E343648FD63C5A179DD59446645F696400645E4D2960AD80074930E4FC440004}}, operationType=replace, clusterTime=Timestamp{value=6800312957747068930, seconds=1583321243, inc=2}, fullDocument=Document{{_id=5e4d2960ad80074930e4fc44, fechaCreacion=Thu Jan 02 00:00:00 CET 2020, fechaActualizacion=Tue Jun 02 00:00:00 CEST 2020, payload=Document{{idRegla=1, condiciones=color == Grey/Black, origin == Portugal, category == Socks12 , fechaInicio=Thu Jan 02 00:00:00 CET 2020, fechaFin=Wed Jan 02 00:00:00 CET 2030, estado=1, drl=package com.inditex.lo.gescodev.model.drools import com.inditex.lo.gescodev.api.dto.ArticleDTO; import com.inditex.lo.gescodev.api.dto.MatchDTO; import java.util.List; rule \"Calcetines grises y negros con origen Portugal\" when $article : ArticleDTO(color == \"Grey/Black\", origin == \"Portugal\", category == \"Socks\") $list : List() then MatchDTO matching = new MatchDTO(); matching.setRuleId(1L); matching.setRuleDescription(\"color == Grey/Black, origin == Portugal, category == Socks\"); matching.setPriority(0); $list.add(matching); end, prioridad=0}}}}, ns=Document{{db=ReglasGestorCodigos, coll=CatalogoReglasKCPruebas}}, documentKey=Document{{_id=5e4d2960ad80074930e4fc44}}}}");
//        sender.send(mongoDataDTO);
    }
}
