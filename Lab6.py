"""[first line= process number
    2nd line = number of element
    then max matrix
    then allocation matrix
    lastly available 
    ]
"""




f=open("input.txt")
p=int(f.read(1))
r=int(f.read(2))
count=0
help_index=0
process=[]
p_max=[]
p_allocation=[]
p_available=[]
new_available=[]
safe_sequence=[]
flag=[]
content=f.readlines()[1:p+1]
for line in content:
    m=[item.strip() for item in line.split(' ')]
    p_max.append(m)
for i in range(p):
    for j in range(r):
        p_max[i][j]=int(p_max[i][j])
f=open("input.txt")
content=f.readlines()[2+p:2*p+2]
for line in content:
    m=[item.strip() for item in line.split(' ')]
    p_allocation.append(m)
for i in range(p):
    for j in range(r):
        p_allocation[i][j]=int(p_allocation[i][j])
f=open("input.txt")
content=f.readlines()[-1]
i=0
while i<len(content):
    m=int(content[i])
    p_available.append(m)
    i+=2
f.close()
need = [[0 for i in range(r)] for j in range(p)]
new_available = [[0 for i in range(r)] for j in range(p)]
for i in range(p):
    for j in range(r):
        need[i][j]=p_max[i][j]-p_allocation[i][j]
print("Need Matrix :")
for i in range(len(need)):
    for j in range(len(need[i])):
        print(need[i][j], end=' ')
    print()
ch='A'
for i in range(p):
    x= chr(ord(ch) + i)
    process.append(x)
for i in range(p):
    flag.append(0)
loop=0



def helper(row):             #new available calculation
    global new_available
    for i in range (r):
        new_available[help_index][i]=p_available[i]+ p_allocation[row][i] 
        
        
def check(ava, nd):
    return(all(ava[i] >= nd[i] for i in range(len(ava))))



while True:
    loop=loop%p
    if count==p:
        break
    else:
        if flag[loop]==0 and check(p_available, need[loop]):
            safe_sequence.append(process[loop])
            helper(loop)
            p_available=new_available[help_index]
            help_index+=1
            flag[loop]=1
            count+=1
            
        loop+=1
print("Safe Sequence is:")
for i in range(len(need)):
        print(safe_sequence[i], end=' ')
print()
print("Change in available resource matrix :")
for i in range(len(new_available)):
    for j in range(len(new_available[i])):
        print(new_available[i][j], end=' ')
    print()