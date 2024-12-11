#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

// Function to check if a character exists in the string
int containsChar(const char* s, char c) {
    for (int i = 0; i < strlen(s); i++) {
        if (s[i] == c) {
            return 1; // Found the character
        }
    }
    return 0; // Character not found
}

// Helper function to find the longest nice substring recursively
char* longestNiceSubstringHelper(char* s) {
    int len = strlen(s);
    if (len < 2) {
        return "";
    }

    for (int i = 0; i < len; i++) {
        char c = s[i];
        if (containsChar(s, toupper(c)) && containsChar(s, tolower(c))) {
            continue;
        }

        // Split into two substrings and find the longest nice substring recursively
        char* sub1 = (char*)malloc((i + 1) * sizeof(char));
        strncpy(sub1, s, i);
        sub1[i] = '\0';

        char* sub2 = (char*)malloc((len - i) * sizeof(char));
        strcpy(sub2, &s[i + 1]);

        char* niceSub1 = longestNiceSubstringHelper(sub1);
        char* niceSub2 = longestNiceSubstringHelper(sub2);

        free(sub1);
        free(sub2);

        return strlen(niceSub1) >= strlen(niceSub2) ? niceSub1 : niceSub2;
    }

    return s;
}

// Function to find the longest nice substring
char* longestNiceSubstring(char* s) {
    return longestNiceSubstringHelper(s);
}

// Driver code to test the function
int main() {
    char str[] = "YazaAay";
    char* result = longestNiceSubstring(str);
    printf("Longest Nice Substring: %s\n", result);
    return 0;
}
