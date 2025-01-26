import requests
from datetime import datetime, timedelta

# Replace with your GitHub organization name
ORG_NAME = 'your_organization_name'
# Replace with your GitHub personal access token
TOKEN = 'your_personal_access_token'

def fetch_open_prs(org_name):
    url = f'https://api.github.com/orgs/{org_name}/repos'
    headers = {
        'Authorization': f'token {TOKEN}',
        'Accept': 'application/vnd.github.v3+json'
    }

    # Fetch all repositories in the organization
    response = requests.get(url, headers=headers)
    if response.status_code != 200:
        print(f"Error fetching repositories: {response.status_code}")
        return []

    repos = response.json()
    open_prs = []
    five_days_ago = datetime.now() - timedelta(days=5)

    # Iterate through each repository to fetch open PRs
    for repo in repos:
        repo_name = repo['name']
        pr_url = f'https://api.github.com/repos/{org_name}/{repo_name}/pulls?state=open'
        pr_response = requests.get(pr_url, headers=headers)

        if pr_response.status_code == 200:
            prs = pr_response.json()
            for pr in prs:
                created_at = datetime.strptime(pr['created_at'], "%Y-%m-%dT%H:%M:%SZ")
                if created_at < five_days_ago:
                    open_prs.append({
                        'repo': repo_name,
                        'title': pr['title'],
                        'url': pr['html_url'],
                        'created_at': pr['created_at'],
                        'user': pr['user']['login']
                    })
        else:
            print(f"Error fetching PRs for {repo_name}: {pr_response.status_code}")

    return open_prs

def main():
    open_prs = fetch_open_prs(ORG_NAME)
    if open_prs:
        print(f"Open Pull Requests in '{ORG_NAME}' older than 5 days:")
        for pr in open_prs:
            print(f"- Repository: {pr['repo']}, Title: {pr['title']}, URL: {pr['url']}, Created At: {pr['created_at']}, User: {pr['user']}")
    else:
        print(f"No open pull requests older than 5 days found in '{ORG_NAME}'.")

if __name__ == '__main__':
    main()
