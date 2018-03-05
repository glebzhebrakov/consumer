package hme.poc.hmepoc.rest

import hme.poc.hmepoc.dto.Statistic
import hme.poc.hmepoc.service.MessageStoragePort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class StatisticController {

    @Autowired
    private MessageStoragePort messageStoragePort

    @GetMapping(value = '/statistic', produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Statistic> statistic(){
        new ResponseEntity<Statistic>(messageStoragePort.statistic(), HttpStatus.OK)
    }
}
