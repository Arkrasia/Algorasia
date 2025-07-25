# 백준 2608 로마 숫자
import sys
input = sys.stdin.readline

rom_symbol = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
except_symbol = {'IV':4, 'IX':9, 'XL':40, 'XC':90, 'CD':400, 'CM':900}
def romToArabic(rom):
    arabic = 0
    visited = [True]*len(rom)
    for i in range(len(rom)):
        if visited[i]:
            if len(rom)>i+1 and rom[i:i+2] in except_symbol:
                arabic += except_symbol[rom[i:i+2]]
                visited[i:i+2] = False, False
            else:    
                arabic += rom_symbol[rom[i]]
                visited[i] = False
    return arabic

# 한자리수 두자리수 기호 합치기
all = dict(rom_symbol, **except_symbol)
# value 기준으로 내림차순 정렬
sorted_all = dict(sorted(all.items(), key=lambda item: item[1], reverse=True))

def arabicToRom(arabic):
    rom = "" 
    while arabic > 0:
        for k, v in sorted_all.items():
            while arabic >= v:
                rom += k
                arabic -= v
    return rom


rom_num = [input().rstrip() for _ in range(2)]
arabic_num = []
for num in rom_num:
    arabic_num.append(romToArabic(num))

ans = sum(arabic_num)
print(ans)
print(arabicToRom(ans))

