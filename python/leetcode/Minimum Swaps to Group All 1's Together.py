class Solution:
    #
    #   data = [1,0,1,0,1,0,0,1,1,0,1]
    #
    #   result of window size should be the number of 1
    def minSwaps(self, data: List[int]) -> int:
        num_of_one = sum(data)

        min_num_of_zero_in_window = num_of_one - sum(data[:num_of_one])
        cur_num_of_zero_in_windeo = min_num_of_zero_in_window

        i = 1
        while i + num_of_one - 1 < len(data):
            j = i + num_of_one - 1
            if data[i - 1] == 1 and data [j] == 0:
                cur_num_of_zero_in_windeo += 1
            elif data[i - 1] == 0 and data [j] == 1:
                cur_num_of_zero_in_windeo -= 1

            min_num_of_zero_in_window = min(min_num_of_zero_in_window, cur_num_of_zero_in_windeo)
            i += 1

        return min_num_of_zero_in_window
