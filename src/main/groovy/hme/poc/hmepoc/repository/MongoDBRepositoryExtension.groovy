package hme.poc.hmepoc.repository

import hme.poc.hmepoc.dto.MongoDBTestMessage
import hme.poc.hmepoc.dto.Pair
import hme.poc.hmepoc.dto.Statistic

interface MongoDBRepositoryExtension {

    List<MongoDBTestMessage> aggregateBySlidingWindow(long windowsSizeMs)
    Statistic factsStatistic()
}