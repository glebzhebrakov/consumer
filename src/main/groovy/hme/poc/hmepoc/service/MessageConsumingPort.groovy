package hme.poc.hmepoc.service

interface MessageConsumingPort {

    void receive(byte [] message)
}