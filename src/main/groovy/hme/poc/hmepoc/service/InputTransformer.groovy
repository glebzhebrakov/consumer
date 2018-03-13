package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.domain.EventRecord
import hme.poc.hmepoc.dto.domain.transformation.TransformedRecord

interface InputTransformer {

   List<TransformedRecord> transform(List<EventRecord> events)
}