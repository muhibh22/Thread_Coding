import queue

print("Enter number of processes: ")
n=int(input())
pid=[]
arrival_time=[]
burst_time=[]
complete_time=[]
turnaround_time=[]
start_time=[]
pause_time=[]
f=[]
entry=[]
run=[-1]
ready_queue=queue.Queue()
print("Enter Time quantum: ")
quantum=int(input())
st, tot=0,0
for i in range(n):                 #input
    print("Enter process id for process ", i+1)
    pid.append(input())
    print("Enter arrival time for process ", i+1)
    arrival_time.append(int(input()))
    print("Enter cpu burst for process ", i+1)
    burst_time.append(int(input()))
    f.append(0)
    start_time.append(None)
    complete_time.append(0)
    turnaround_time.append(0)
    pause_time.append(0)
    entry.append(None)
def ready():
    for i in range(n):
        if st>= arrival_time[i] and f[i]!=1 and entry[i]==None:
            ready_queue.put(i)
            entry[i]=1
    if run[0]!=-1 and f[run[0]]!=1:
        ready_queue.put(run[0])
    if ready_queue.empty():
        return -1
    
    else:
        run[0]=ready_queue.get()
        return run[0]
    


a=True
while True:
    if(tot==n):
        break
    b=ready()
    if b!=-1 :
        if start_time[b]==None:
            start_time[b]=st
        if burst_time[b]==0:
            burst_time[b]-=1
            complete_time[b]=st
            tot+=1
            f[b]=1
            
        else:
            for i in range(quantum):
                if burst_time[b]==0:
                    burst_time[b]-=1
                    complete_time[b]=st
                    tot+=1
                    f[b]=1
                    break
                st+=1
                burst_time[b]-=1
                for i in range(n):
                    if i!=b and st>arrival_time[i] and f[i]!=1:
                        pause_time[i]+=1
            # if f[b]!=1:
            #     ready_queue.put(b)
    else :
            st+=1
for i in range(n):
    print("Complete time for ", pid[i],"is ", complete_time[i])
print()
for i in range(n):
    turnaround_time[i]=complete_time[i]-arrival_time[i]
print()
for i in range(n):
    print("Waiting time for ", pid[i],"is ", pause_time[i])
print()
for i in range(n):
    print("Turnaround time for ", pid[i],"is ", turnaround_time[i])
average_ta=0
average_wt=0
for i in range(n):
    average_ta+=turnaround_time[i]
    average_wt+=pause_time[i]
print("Average turnaround time: ", average_ta/n)
print("Average waiting time: ", average_wt/n)
