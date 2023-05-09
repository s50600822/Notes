import boto3
import hashlib
import random
import string

dynamodb = boto3.resource('dynamodb')
table_name = 'URLShortener'
table = dynamodb.Table(table_name)

def generate_short_url(original_url):
    md5_hash = hashlib.md5(original_url.encode()).hexdigest()
    short_url = md5_hash[:8]  # 8 characters as the short URL

    return short_url

def save_url(original_url):
    short_url = generate_short_url(original_url)
    table.put_item(Item={
        'ShortURL': short_url,
        'OriginalURL': original_url
    })

    return short_url

def retrieve_url(short_url):
    response = table.get_item(Key={'ShortURL': short_url})
    item = response.get('Item')

    if item:
        return item['OriginalURL']
    else:
        return None

original_url = 'https://example.com'
short_url = save_url(original_url)
retrieved_url = retrieve_url(short_url)

print(f"Original URL: {original_url}")
print(f"Short URL: {short_url}")
print(f"Retrieved URL: {retrieved_url}")