# Create Table
aws --endpoint="http://localhost:4566" dynamodb delete-table --region "us-east-1" --table-name "schedule"