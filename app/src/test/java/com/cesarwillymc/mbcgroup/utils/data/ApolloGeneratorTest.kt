package com.cesarwillymc.mbcgroup.utils.data

object ApolloGeneratorTest {
    const val surveyNoFound = """{
    "data": {
        "surveys": {
            "edges": [],
            "pageInfo": {
                "hasNextPage": true
            },
            "totalCount": 20
        }
    }
}"""

    const val surveys = """{
    "data": {
        "surveys": {
            "edges": [
                {
                    "node": {
                        "id": "d5de6a8f8f5f1cfe51bc",
                        "title": "Scarlett Bangkok",
                        "coverImageUrl": "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_",
                        "description": "We'd love ot hear from you!"
                    }
                },
                {
                    "node": {
                        "id": "ed1d4f0ff19a56073a14",
                        "title": "ibis Bangkok Riverside",
                        "coverImageUrl": "https://dhdbhh0jsld0o.cloudfront.net/m/287db81c5e4242412cc0_",
                        "description": "We'd love to hear from you!"
                    }
                },
                {
                "node": {
                        "id": "270130035d415c1d90bb",
                        "title": "21 on Rajah",
                        "coverImageUrl": "https://dhdbhh0jsld0o.cloudfront.net/m/0221e768b99dc3576210_",
                        "description": "We'd love to hear from you!"
                    }
                }
            ],
            "pageInfo": {
                "hasNextPage": true
            },
            "totalCount": 20
        }
    }
}"""
}
