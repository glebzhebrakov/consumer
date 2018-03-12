package hme.poc.hmepoc.repository

import hme.poc.hmepoc.dto.MongoDBTestMessage
import hme.poc.hmepoc.dto.Pair
import hme.poc.hmepoc.dto.Statistic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.data.mongodb.core.aggregation.GroupOperation
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation
import org.springframework.data.mongodb.core.aggregation.SortOperation
import org.springframework.data.mongodb.core.query.Query

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort

class MongoDBRepositoryExtensionImpl implements MongoDBRepositoryExtension {

    @Autowired
    private MongoOperations mongoOperations

    @Override
    List<MongoDBTestMessage> aggregateBySlidingWindow(long windowsSizeMs) {
        []
    }

    @Override
    Statistic factsStatistic() {
        def statistic = new Statistic()
        def payloadGroup = group('payload').first('payload').as('payload').count().as('count')
        def sortCountDesc = sort(new Sort(Sort.Direction.DESC, 'count'))
        def projectToMatchModel = project()
                .andExpression("count").as("count")
                .andExpression("payload").as("payload")

        statistic.messagesCount = mongoOperations.count(new Query(), MongoDBTestMessage)

        def aggregation = Aggregation.newAggregation( payloadGroup, sortCountDesc, projectToMatchModel )
        AggregationResults<Pair> result = mongoOperations.aggregate(aggregation, 'mongoDBTestMessage', Pair)
//
        statistic.factCounts = result as List
        statistic
    }
}
