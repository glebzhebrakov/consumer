package hme.poc.hmepoc.service

import hme.poc.hmepoc.dto.domain.EventRecord
import hme.poc.hmepoc.dto.domain.transformation.TransformedAggregation
import hme.poc.hmepoc.dto.domain.transformation.TransformedRecord

interface MessageStoragePort {
    List<TransformedRecord> transform( final List<EventRecord> events )
    List<TransformedRecord> transform( final List<EventRecord> events, String collectionName )
    List<TransformedAggregation> aggregate()
    List<TransformedAggregation> aggregate(String collectionName)
}
