# Create Table
aws --endpoint="http://localhost:4566" dynamodb create-table \
  --region "us-east-1" \
  --table-name "schedule" \
  --attribute-definitions \
    "AttributeName=id,AttributeType=S" \
    "AttributeName=patient_id,AttributeType=S" \
  --key-schema \
    "AttributeName=id,KeyType=HASH" \
    "AttributeName=patient_id,KeyType=RANGE" \
  --provisioned-throughput \
      "ReadCapacityUnits=5,WriteCapacityUnits=5"