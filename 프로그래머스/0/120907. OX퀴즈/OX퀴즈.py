def solution(quiz):
    answer = []
    
    for q in quiz:
        list = q.split("=")
        if(eval(list[0]) == int(list[1])):
            answer.append("O")
        else:
            answer.append("X")
    
    return answer