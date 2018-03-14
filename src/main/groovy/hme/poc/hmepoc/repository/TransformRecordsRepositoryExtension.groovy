package hme.poc.hmepoc.repository

import hme.poc.hmepoc.dto.domain.transformation.TransformedAggregation
import hme.poc.hmepoc.dto.domain.transformation.TransformedRecord

interface TransformRecordsRepositoryExtension {

    void saveToCollection(List<TransformedRecord> records,String collectionName)
    List<TransformedAggregation> aggregateEvents()
    List<TransformedAggregation> aggregateEvents(String collectionName)
}