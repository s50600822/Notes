using System;
using System.IO;

namespace YourAppName
{
    class Program
    {
        static void Main(string[] args)
        {
            PrintSystemInfo();
        }

        static void PrintSystemInfo()
        {
            Console.WriteLine("System Information:");
            Console.WriteLine("-------------------");

            // Querying CPU information
            Console.WriteLine("CPU:");
            int coreCount = Environment.ProcessorCount;
            Console.WriteLine($"  Number of Cores: {coreCount}");

            // Querying memory information
            Console.WriteLine("\nMemory:");
            if (File.Exists("/proc/meminfo"))
            {
                string[] lines = File.ReadAllLines("/proc/meminfo");
                foreach (string line in lines)
                {
                    string[] parts = line.Split(':');
                    if (parts.Length == 2)
                    {
                        string name = parts[0].Trim();
                        string value = parts[1].Trim();

                        if (name == "MemTotal" || name == "MemFree")
                        {
                            long memoryKiB = long.Parse(value.Split(' ')[0]);
                            double memoryMiB = memoryKiB / 1024.0;
                            Console.WriteLine($"  {name}: {memoryMiB:F2} MiB");
                        }
                    }
                }
            }
            else
            {
                Console.WriteLine("Memory information retrieval is not supported on this platform.");
            }
        }
    }
}
