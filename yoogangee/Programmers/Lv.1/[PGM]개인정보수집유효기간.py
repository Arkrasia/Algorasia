# 프로그래머스 Lv 1 개인정보 수집 유효기간
def solution(today, terms, privacies):
    answer = []
    terms_dict = {}
    today_arr = list(map(int, today.split('.')))
    
    for term in terms:
        a, b = term.split()
        terms_dict[a] = int(b)*28
    
    for i in range(len(privacies)):
        date, term = privacies[i].split()
        date_arr = list(map(int, date.split('.')))
        year = (today_arr[0] - date_arr[0])*28*12
        month = (today_arr[1] - date_arr[1])*28
        day = (today_arr[2] - date_arr[2])
        total = year+month+day
        if terms_dict[term] <= total:
            answer.append(i+1)
        
    return answer