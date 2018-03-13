package hme.poc.hmepoc.dto.domain.transformation

class DetectorEvent {
    String alias
    Long value = -1

    DetectorEvent(String alias) {
        this.alias = alias
    }
}
