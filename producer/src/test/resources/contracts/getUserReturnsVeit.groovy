package contracts

import org.springframework.cloud.contract.spec.Contract;

Contract.make {
    request {
        //uppercase is required for the client tests to succeed!
        method 'GET'
        //slash is required instead of empty string
        url '/'
    }
    response {
        status 200
        body(
                [
                        [
                                username: 'veit',
                                id      : value(producer(regex(uuid())))
                        ]
                ]
        )
        headers {
            contentType(applicationJson())
        }
    }
}
