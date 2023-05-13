export const questions = [
  {
    questionText: "What is the size limit of a single S3 object",
    answers: [
      {
        answerText: "50TB",
        correctAnswer: true,
      },
      {
        answerText: "50GB",
        correctAnswer: false,
      },
      {
        answerText: "500G",
        correctAnswer: false,
      },
      {
        answerText: "5GB",
        correctAnswer: false,
      },
    ],
  },
  {
    questionText:
      "How much performance 33.33 GiB gp2 give?",
    answers: [
      {
        answerText: "999 IOPS",
        correctAnswer: false,
      },
      {
        answerText: "500 IOPS",
        correctAnswer: false,
      },
      {
        answerText: "70 IOPS",
        correctAnswer: false,
      },
      {
        answerText: "100 IOPS",
        correctAnswer: true,
      },
    ],
  },
  {
    questionText: "Using Amazon DynamoDB, a strongly consistent read request of an item up to 4 KB requires how many read unit",
    answers: [
      {
        answerText: "0.5",
        correctAnswer: false,
      },
      {
        answerText: "1",
        correctAnswer: true,
      },
      {
        answerText: "2",
        correctAnswer: false,
      },
      {
        answerText: "4",
        correctAnswer: false,
      },
    ],
  },
  {
    questionText: "Using Amazon DynamoDB, an eventually consistent read request of an item up to 4 KB requires how many read unit",
    answers: [
      {
        answerText: "0.5",
        correctAnswer: true,
      },
      {
        answerText: "1",
        correctAnswer: false,
      },
      {
        answerText: "2",
        correctAnswer: false,
      },
      {
        answerText: "4",
        correctAnswer: false,
      },
    ],
  },
  {
    questionText: "Using Amazon DynamoDB, A transactional read request of an item up to 4 KB requires how many read unit",
    answers: [
      {
        answerText: "0.5",
        correctAnswer: true,
      },
      {
        answerText: "1",
        correctAnswer: false,
      },
      {
        answerText: "2",
        correctAnswer: false,
      },
      {
        answerText: "4",
        correctAnswer: false,
      },
    ],
  },
  {
    questionText: "Using Kinesis, each shard can support writes up to HOW MANY records per second?",
    answers: [
      {
        answerText: "9000",
        correctAnswer: false,
      },
      {
        answerText: "2000",
        correctAnswer: false,
      },
      {
        answerText: "1000",
        correctAnswer: true,
      },
      {
        answerText: "3000",
        correctAnswer: false,
      },
    ],
  },
  {
    questionText: "S3 Glacier Flexible Retrieval provides how many retrieval options?",
    answers: [
      {
        answerText: "5",
        correctAnswer: false,
      },
      {
        answerText: "3",
        correctAnswer: true,
      },
      {
        answerText: "4",
        correctAnswer: false,
      },
      {
        answerText: "7",
        correctAnswer: false,
      },
    ],
  },
  {
    questionText:
      "The Amazon S3 Glacier Deep Archive storage class provides how many retrieval options ?",
      answers: [
        {
          answerText: "5",
          correctAnswer: false,
        },
        {
          answerText: "3",
          correctAnswer: true,
        },
        {
          answerText: "4",
          correctAnswer: false,
        },
        {
          answerText: "7",
          correctAnswer: false,
        },
      ],
  },
  {
    questionText: "Amazon Kinesis Data Streams can push multiple responses to a client without waiting for the client to request those resources?",
    answers: [
      {
        answerText: "YEP, MAGIC!",
        correctAnswer: true,
      },
      {
        answerText: "WTF! NO, you have to pull!",
        correctAnswer: false,
      },
    ],
  },
  {
    questionText: "Which is not a valid routing policy for Route53?",
    answers: [
      {
        answerText: "latency",
        correctAnswer: false,
      },
      {
        answerText: "simple",
        correctAnswer: false,
      },
      {
        answerText: "failover",
        correctAnswer: false,
      },
      {
        answerText: "multivalue",
        correctAnswer: false,
      },
      {
        answerText: "weighted",
        correctAnswer: false,
      },
      {
        answerText: "ip-based",
        correctAnswer: false,
      },
      {
        answerText: "random",
        correctAnswer: true,
      },
    ],
  },
  {
    questionText: "Network Load Balancer operates on which level of OSI model",
    answers: [
      {
        answerText: "3",
        correctAnswer: false,
      },
      {
        answerText: "4",
        correctAnswer: true,
      },
      {
        answerText: "5",
        correctAnswer: false,
      },
      {
        answerText: "6",
        correctAnswer: false,
      },
      {
        answerText: "7",
        correctAnswer: false,
      },
    ],
  },
  {
    questionText: "I just bought a domain example.net on Route53. Which DNS record type I can use to map example.net to my existing endpoint elb-aussie-12345.elb.amazon.com",
    answers: [
      {
        answerText: "CNAME",
        correctAnswer: true,
      },
      {
        answerText: "A",
        correctAnswer: true,
      },
      {
        answerText: "Neither",
        correctAnswer: false,
      },
      {
        answerText: "Either one will do",
        correctAnswer: false,
      }
    ],
  },
  {
    questionText: "A company runs a serverless mobile app that uses Amazon API Gateway, AWS Lambda functions, Amazon Cognito, and Amazon DynamoDB. During large surges in traffic, users report intermittent system failures. The API Gateway API endpoint is returning HTTP status code 502 (Bad Gateway) errors to valid requests.",
    answers: [
      {
        answerText: "Increase the concurrency quota for the Lambda functions. Configure Amazon CloudWatch to send notification alerts when the ConcurrentExecutions metric approaches the quota",
        correctAnswer: true,
      },
      {
        answerText: "Configure notification alerts for the quota of transactions per second on the API Gateway API endpoint. Create a Lambda function that will increase the quota when the quota is reached.",
        correctAnswer: false,
      },
      {
        answerText: "Shard users to Amazon Cognito user pools in multiple AWS Regions to reduce user authentication latency",
        correctAnswer: false,
      },
      {
        answerText: "Use DynamoDB strongly consistent reads to ensure that the client application always receives the most recent data",
        correctAnswer: false,
      }
    ],
  },
  {
    questionText: "Which Route 53 routing lets Amazon Route 53 route traffic to your resources based on the geographic location of your users and your resources ?",
    answers: [
      {
        answerText: "Geoproximity",
        correctAnswer: true,
      },
      {
        answerText: "Geolocation",
        correctAnswer: false,
      }
    ],
  },
  {
    questionText: "S3 One Zone-IA storage class availability is?",
    answers: [
      {
        answerText: "99.5%",
        correctAnswer: true,
      },
      {
        answerText: "99.9%",
        correctAnswer: false,
      },
      {
        answerText: "99.99%",
        correctAnswer: false,
      },
      {
        answerText: "99.999999999%",
        correctAnswer: false,
      }
    ],
  },
  {
    questionText: "S3 Glacier Instant Retrieval, S3 Standard-IA, S3 Intelligent-Tiering storage classes availability is?",
    answers: [
      {
        answerText: "99.5%",
        correctAnswer: false,
      },
      {
        answerText: "99.9%",
        correctAnswer: true,
      },
      {
        answerText: "99.99%",
        correctAnswer: false,
      },
      {
        answerText: "99.999999999%",
        correctAnswer: false,
      }
    ],
  },
];
