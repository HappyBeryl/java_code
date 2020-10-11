#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <strings.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main()
{
	int ret;
	int fd = open("a.txt", O_RDONLY);
	if (fd < 0) 
	{
		perror("open");
		return -1;
	}
	char buf[101];
	memset(buf, 0, sizeof(buf)); 
	ret = read(fd, buf, sizeof(buf) - 1);
	if (ret < 0)
	{
		perror("read");
		return -1;
	}
	close(fd);

	fd = 0;
	fd = open("b.txt", O_WRONLY | O_CREAT | O_TRUNC, 0666);
	if (fd < 0)
	{
		perror("open");
		return -1;
	}
	if (0 > write(fd, buf, strlen(buf))) 
	{
		perror("write");
		return -1;
	}
	close(fd);

	return 0;
}